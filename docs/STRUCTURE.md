# Structure for Archetype Java CLI

## Overview

Spring Boot CLI application with Spring Shell commands. Provides a version command, strongly-typed configuration via `@ConfigurationProperties`, and structured JSON logging. Dual testing strategy separates fast unit tests from full-context integration tests.

## Folder Structure

```
src/
  main/
    java/
      com/aiddbot/archetype/cli/
        ArchetypeJavaCliApplication.java   # Spring Boot entrypoint (CLI)
        commands/
          VersionCommands.java             # Spring Shell command: version
        config/
          CliProperties.java               # Strongly-typed configuration properties
          WebClientConfig.java             # Preconfigured reactive HTTP client (F2.1)
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
        ArchetypeJavaCliApplicationTest.java      # Integration test (Spring context)
        ArchetypeJavaCliApplicationUnitTest.java  # Unit test (mocks, fast)
        commands/
          VersionCommandsUnitTest.java            # Unit test for version command
          VersionCommandsIntegrationTest.java     # Integration test for Shell
        config/
          CliPropertiesTest.java                  # Unit/validation tests for configuration
          WebClientConfigIntegrationTest.java     # Integration tests for WebClient (headers/timeouts)
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
- `src/main/java/com/aiddbot/archetype/cli/config/CliProperties.java`: Configuration properties with validation and metadata generation.
- `src/main/java/com/aiddbot/archetype/cli/runtime/*.java`: Exit codes, coded exception, and mapper used to standardize process termination behavior (F1.5).

## Bill of Materials

- Language: Java 21
- Framework: Spring Boot 3.3.x, Spring Shell 3.3.x
- State Management: Not applicable (CLI)
- Styling: Spotless (Google Java Format)
- Testing: JUnit 5, Mockito, Spring Boot Test, Maven Surefire
- Build Tools: Maven, Spring Boot Maven Plugin, Maven Compiler/Enforcer, Spotless

> End of STRUCTURE for Archetype Java CLI, last updated on 2025-08-28.
