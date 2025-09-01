# Structure for Archetype Java CLI

## Overview

Spring Boot CLI application with Spring Shell commands. Provides a version command, strongly-typed configuration via `@ConfigurationProperties`, and structured JSON logging. Testing strategy focuses on fast unit tests.
Implements a sample Weather flow (Epic 3): IP geolocation (F3.1), Open‑Meteo client (F3.2), human‑readable presenter (F3.3), and graceful errors/exit codes (F3.4).

## Folder Structure

```
src/
  main/
    java/
      com/aiddbot/archetype/cli/
        ArchetypeJavaCliApplication.java   # Spring Boot entrypoint (CLI)
        commands/
          VersionCommands.java             # Spring Shell command: version
          WeatherCommands.java             # Spring Shell command: weather (F3.1–F3.4)
        config/
          CliProperties.java               # Strongly-typed configuration properties
          WebClientConfig.java             # Preconfigured reactive HTTP client (F2.1)
        integrations/
          ipapi/
            IpGeoClient.java               # IP → approx coordinates client (F3.1)
            IpGeoResponse.java             # Minimal mapping for ip-api.com (F3.1)
          openmeteo/
            OpenMeteoClient.java           # Current weather client (F3.2)
            OpenMeteoCurrent.java          # Mapping for current_weather (F3.2)
            WeatherObservation.java        # Domain object for presentation (F3.2)
        presenter/
          WeatherPresenter.java            # Compose human-friendly summary (F3.3)
        errors/
          UserFacingErrors.java            # Consistent error line for stderr (F3.4)
        runtime/
          ExitCodes.java                   # Canonical process exit codes
          CodedException.java              # Exception carrying an exit code
          ExitCodeExceptionMapper.java     # Contract to map Throwable -> ExitCodes
          DefaultExitCodeExceptionMapper.java # Default mapping implementation
    resources/
      application.properties               # Default configuration (filtered)
      banner.txt                           # CLI banner
      logback-spring.xml                   # Structured JSON logging config
  test/
    java/
      com/aiddbot/archetype/cli/
        ArchetypeJavaCliApplicationUnitTest.java  # Unit test (mocks, fast)
        commands/
          VersionCommandsUnitTest.java            # Unit test for version command
        config/
          CliPropertiesTest.java                  # Unit/validation tests for configuration
        runtime/
          ExitCodesTest.java                      # Unit tests for exit code values
          CodedExceptionTest.java                 # Unit tests for coded exception semantics
          DefaultExitCodeExceptionMapperTest.java # Unit tests for exception mapping
    resources/
      application-test.properties
```

### Key files

- `src/main/java/com/aiddbot/archetype/cli/ArchetypeJavaCliApplication.java`: Spring Boot entrypoint configuring a non-web CLI.
- `src/main/java/com/aiddbot/archetype/cli/commands/VersionCommands.java`: Spring Shell command exposing the `version` action.
- `src/main/java/com/aiddbot/archetype/cli/commands/WeatherCommands.java`: Weather command orchestrating IP geolocation (F3.1), Open‑Meteo (F3.2), and presentation (F3.3).
- `src/main/java/com/aiddbot/archetype/cli/config/CliProperties.java`: Configuration properties with validation and metadata generation.
- `src/main/java/com/aiddbot/archetype/cli/runtime/*.java`: Exit codes, coded exception, and mapper used to standardize process termination behavior (F1.5).
- `src/main/java/com/aiddbot/archetype/cli/integrations/ipapi/*`: Client and DTO for ip-api.com (F3.1).
- `src/main/java/com/aiddbot/archetype/cli/integrations/openmeteo/*`: Client/DTO/domain for Open‑Meteo (F3.2).
- `src/main/java/com/aiddbot/archetype/cli/presenter/WeatherPresenter.java`: Presenter for human-readable output (F3.3).

## Bill of Materials

- Language: Java 21
- Framework: Spring Boot 3.5.x, Spring Shell 3.3.x
- State Management: Not applicable (CLI)
- Styling: Spotless (Google Java Format)
- Testing: JUnit 5, Mockito, Spring Boot Test, Maven Surefire
- Build Tools: Maven, Spring Boot Maven Plugin, Maven Compiler/Enforcer, Spotless

> End of STRUCTURE for Archetype Java CLI, last updated on 2025-09-01.

## Build & Packaging (E4)

- Java 21 enforced via Maven Enforcer and `maven-compiler-plugin` with `--release=21`.
- Tests split: Surefire for unit tests; Failsafe declared for ITs (skipped by default via `-DskipITs=true`).
- Resource filtering limited to `application.properties`; other resources unfiltered.
- Reproducible builds enabled via fixed `project.build.outputTimestamp`.
- Spring Boot Maven Plugin:
  - `build-info` goal to generate `META-INF/build-info.properties`.
  - `repackage` goal to create an executable fat JAR.
- Artifact: `target/archetype-java-cli-<version>.jar` runnable with `java -jar`.
