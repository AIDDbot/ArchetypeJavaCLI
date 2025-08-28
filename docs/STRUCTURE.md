# Project Structure

This document outlines the high-level structure following the "Screaming Architecture" approach.

## Source layout

```
src/
  main/
    java/
      com/aiddbot/archetype/cli/
        ArchetypeJavaCliApplication.java   # Spring Boot entrypoint (CLI)
    resources/
      application.properties               # Default configuration
  test/
    java/
      com/aiddbot/archetype/cli/
        ArchetypeJavaCliApplicationTest.java     # Integration test (Spring context)
        ArchetypeJavaCliApplicationUnitTest.java # Unit test (mocks, fast)
    resources/
      application-test.properties
```

## Testing Strategy

This project implements a dual testing approach:

### Unit Tests (`*UnitTest.java`)
- **Purpose**: Fast, isolated testing of individual methods
- **Technology**: JUnit 5 + Mockito
- **Speed**: < 2 seconds 
- **Context**: No Spring context startup
- **Usage**: `mvn test -Dtest=*UnitTest`

### Integration Tests (`*Test.java`)
- **Purpose**: End-to-end testing with full Spring context
- **Technology**: `@SpringBootTest` with Shell disabled
- **Speed**: ~5-10 seconds
- **Context**: Full Spring Boot application context
- **Usage**: `mvn test -Dtest=*Test -Dtest=!*UnitTest`

## Features

- F1.1 Project bootstrap (Maven + Spring Boot + Spring Shell)
  - Entrypoint: `ArchetypeJavaCliApplication`
  - Behavior: boots a non-web Spring context and logs `<appName> v<version> ready` on startup.
  - Status: ✔️ RELEASED
  - Docs:
    - Spec: `docs/backlog/f1.1.spec.md`
    - Design: `docs/backlog/f1.1.design.md`
    - Plan: `docs/backlog/f1.1.plan.md`
    - Tests: `docs/backlog/f1.1.test.md`
