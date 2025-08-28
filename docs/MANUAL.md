# User Manual — Archetype Java CLI

This document explains how to install, run and use the `archetype-java-cli` tool built with Spring Boot and Spring Shell.

## Requirements

- Java 21 installed and available on `PATH`.
- Built JAR: `target/archetype-java-cli-<version>.jar` (for example `target/archetype-java-cli-0.1.0-SNAPSHOT.jar`).

## Installation / Preparation

1. Build the project with Maven (run from the repository root):

   - Ensure Java 21 is installed.
   - Build:
     - mvn clean package

2. Locate the artifact:

   - The executable JAR is produced under `target/` as `archetype-java-cli-<version>.jar`.

## Basic execution

Run the application from the command line:

- Non-interactive mode (run a single command and exit):

  java -jar target/archetype-java-cli-<version>.jar --spring.shell.command="<command>"

- Interactive shell mode:

  java -jar target/archetype-java-cli-<version>.jar

When started in interactive mode you will see the banner and a Spring Shell prompt. Use `help` to list commands.

## Main commands

This archetype provides several example commands. The most relevant are:

- version
  - Description: Prints the application version and build metadata.
  - Usage: `version` (or `app version` depending on command grouping)

- weather
  - Description: Sample command that resolves location (by IP if coordinates are not provided) and fetches current weather from Open‑Meteo.
  - Basic usage:
    - `weather` — attempts to resolve location by IP and prints current conditions.
    - `weather --lat <lat> --lon <lon>` — fetches weather for the provided coordinates.
  - Output: Human-friendly summary including temperature, condition and source metadata.

Use `help <command>` to view options and available flags for each command.

## Configuration via environment variables

The application supports configuration through properties and environment variables. Common configurable properties include:

- `APP_IPAPI_URL` (or the property `cli.endpoints.ipapi` in `application.properties`)
  - Base URL for the IP geolocation service (ip-api or a configurable provider).

- `APP_OPENMETEO_URL` (or the property `cli.endpoints.openmeteo`)
  - Base URL for Open‑Meteo or the configured weather provider.

- `APP_HTTP_TIMEOUT_MS` (or `cli.http.timeoutMs`)
  - HTTP timeout in milliseconds for outbound calls.

- `APP_LOG_LEVEL` (or `logging.level.root` / `LOG_LEVEL` depending on your environment)
  - Log level (INFO, DEBUG, WARN, ERROR).

Notes:
- The exact property names and their mapping to environment variables are defined in `src/main/java/.../config/CliProperties.java`.
- The `APP_*` names above are illustrative; check `CliProperties` or `application.properties` for the precise keys.

## Usage examples

1. Print version:

   java -jar target/archetype-java-cli-0.1.0-SNAPSHOT.jar --spring.shell.command=version

2. Fetch weather for specific coordinates:

   java -jar target/archetype-java-cli-0.1.0-SNAPSHOT.jar --spring.shell.command="weather --lat 40.4168 --lon -3.7038"

3. Run with custom environment variables (example in Bash):

   APP_OPENMETEO_URL="https://api.open-meteo.com/v1/forecast" APP_HTTP_TIMEOUT_MS=5000 \
   java -jar target/archetype-java-cli-0.1.0-SNAPSHOT.jar --spring.shell.command=weather

## Output and exit codes

- Exit code 0: success.
- Non-zero exit codes: errors. Canonical exit codes are defined in the `runtime/ExitCodes.java` class.
  - For details and mapping between exceptions and codes, see `src/main/java/com/aiddbot/archetype/cli/runtime/ExitCodes.java` and `DefaultExitCodeExceptionMapper.java`.

Error messages intended for end users are written to stderr; structured logs (when enabled) are emitted to the configured logger.

## Logging

- Default logging configuration resides in `src/main/resources/logback-spring.xml`.
- Change log levels using environment variables or properties (see the Configuration section above).

## Troubleshooting

- JAR not produced:
  - Make sure you ran `mvn clean package` and that the build completed without compilation errors.

- `java` not found:
  - Install Java 21 and ensure `java -version` reports the correct runtime.

- Network errors when using `weather`:
  - Check `APP_HTTP_TIMEOUT_MS` if you suspect timeouts.
  - Verify that the URLs configured in `CliProperties` (ip-api / openmeteo) are reachable from your network.

- Configuration validation errors:
  - If mandatory properties are missing the application may fail to start with validation errors; review `application.properties` and `CliProperties`.

## Additional resources and documentation

- Project structure: `docs/STRUCTURE.md`.
- Backlog and feature status: `docs/BACKLOG.md`.
- PRD: `docs/PRD.md`.
- Design and specification documents: `docs/backlog/`.

## Contact / Contributing

- Follow the usual Git workflow: create a branch, make changes and open a pull request against `main`.
- To change the documentation, edit `docs/MANUAL.md` and add concrete examples that match the actual implemented commands.

---

End of manual.
