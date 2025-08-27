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
        ArchetypeJavaCliApplicationTest.java  # Context smoke test
    resources/
      application-test.properties
```

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
