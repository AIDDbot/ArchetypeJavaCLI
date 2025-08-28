# Archetype Java CLI

An archetype for building Java command-line interfaces using Spring Boot and Spring Shell. It provides a runnable scaffold, a sample weather command, and docs/tests to kick-start new CLI projects.

## Documentation

- [Project Requirements Document (PRD)](./docs/PRD.md)
- [Domain Model](./docs/DOMAIN.md)
- [Systems Architecture](./docs/SYSTEMS.md)
- [Backlog](./docs/BACKLOG.md)
- [Briefing](./docs/archetype-java_cli.briefing.md)

## Install & Run

Prerequisites:

- Java 21 (JDK) in PATH
- Maven 3.9+

Build and run tests:

```bash
# Run all tests (unit + integration)
mvn -q clean test

# Run only unit tests (fast, no Spring context)
mvn test -Dtest=*UnitTest

# Run only integration tests (slower, full Spring context)
mvn test -Dtest=*Test -Dtest=!*UnitTest

# Use unit tests for regular development and CI/CD pipelines (fast feedback)
# Use integration tests sparingly for end-to-end validation (slow but thorough)
# Always run mvn clean when encountering failures to clear stale compiled classes

```

Run the application (non-web CLI):

```bash
mvn -q spring-boot:run
```

Or package and run the JAR:

```bash
mvn -q -DskipTests package
java -jar target/archetype-java-cli-0.1.0-SNAPSHOT.jar
```

Environment hints:

- To set the app name or version when running locally:

```bash
SPRING_APPLICATION_NAME=archetype-java-cli APP_VERSION=dev mvn -q spring-boot:run
```

## About

- Author: [Alberto Basalo](https://albertobasalo.dev)
- GitHub Org: https://github.com/AIDDbot
- Repository: https://github.com/AIDDbot/ArchetypeJavaCLI