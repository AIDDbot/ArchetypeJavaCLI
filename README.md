# Archetype Java CLI

An archetype for building Java command-line interfaces using Spring Boot and Spring Shell. It provides a runnable scaffold, a sample weather command, and docs/tests to kick-start new CLI projects.

## Documentation

- [Project Requirements Document (PRD)](./docs/PRD.md)
- [Domain Model](./docs/DOMAIN.md)
- [Systems Architecture](./docs/SYSTEMS.md)
- [Backlog](./docs/BACKLOG.md)
- [Briefing](./docs/archetype-java_cli.briefing.md)
- [Project Structure](./docs/STRUCTURE.md)

## Install & Run

- [User Manual](./docs/MANUAL.md)

Prerequisites:

- Java 21 (JDK) in PATH
- Maven 3.9+

Build and run tests:

```bash
# Run tests
mvn -q clean test

# Run the application:
mvn -q spring-boot:run

# Or package and run the JAR:
mvn -q -DskipTests package
java -jar target/archetype-java-cli-0.1.0-SNAPSHOT.jar
```

## Configuration

### Logging

- Structured JSON logs to STDOUT and `/logs` folder
- Default log level is `ERROR`, but can be overridden via Spring properties or environment variables.

Examples:

```bash
# Default only ERROR
mvn -q spring-boot:run

# Override via environment variable
LOGGING_LEVEL_ROOT=INFO mvn -q spring-boot:run
```

### Environment:

- To set the app name or version when running locally:

```bash
SPRING_APPLICATION_NAME=archetype-java-cli APP_VERSION=dev mvn -q spring-boot:run
```


## About

- Author: [Alberto Basalo](https://albertobasalo.dev)
- GitHub Org: https://github.com/AIDDbot
- Repository: https://github.com/AIDDbot/ArchetypeJavaCLI