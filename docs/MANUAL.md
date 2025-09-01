# User Manual — Archetype Java CLI

This document explains how to install, run and use the `archetype-java-cli` tool built with Spring Boot and Spring Shell.

## Requirements

- Java 21 installed and available on `PATH`.
- Built JAR: `target/archetype-java-cli-<version>.jar` (for example `target/archetype-java-cli-0.1.0-SNAPSHOT.jar`).
- Maven 3.8+ for building.

## Installation / Preparation

1. Ensure Java 21 is installed.
2. Build the project from the repository root:

   ```
   mvn -DskipITs=true clean package
   ```

3. Locate the produced artifact under `target/`: `archetype-java-cli-<version>.jar`.

## Run

Start the interactive shell:

```
java -jar target/archetype-java-cli-<version>.jar
```

Run a single command and exit (example: version):

```
java -jar target/archetype-java-cli-<version>.jar --spring.shell.command=version
```

Run the weather command with coordinates:

```
java -jar target/archetype-java-cli-<version>.jar --spring.shell.command="weather --lat 40.4168 --lon -3.7038"
```

## Common commands

- version — prints build and runtime metadata
- weather — sample flow: resolves location (by IP if not provided) and fetches current weather

## Configuration

Configuration is declared in `application.properties` and bound to `CliProperties`. Override settings with system properties or environment variables as needed. See `CliProperties` in code for exact property keys.

## Logging and exit codes

- Structured logging is configured via `logback-spring.xml`.
- Exit codes are defined in `runtime/ExitCodes.java`; `CodedException` maps failures to canonical codes used by the CLI.

## Tests

Run unit tests:

```
mvn -DskipITs=true test
```

Integration tests are separated and run via the Failsafe plugin when appropriate.

## Where to look next

- Architecture and structure: `docs/STRUCTURE.md`
- Backlog and feature status: `docs/BACKLOG.md`

---

> End of MANUAL for Archetype Java CLI, last updated on 2025-09-01.
