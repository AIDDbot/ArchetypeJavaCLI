# Backlog for Archetype Java CLI

> Epic Priority Legend: ‼️ Critical | ❗ High  |❕ Normal

> Feature Status Legend: ⛔ BLOCKED | ⏳ PENDING | ⛪ SPECIFIED | ✏️ DESIGNED | 📝 PLANNED | ✨ CODED | ✅ TESTED | ⛲ CLEANED | ✔️ RELEASED 

## E1 CLI Scaffold and Runtime ‼️ Critical

- Provide a runnable Spring Boot + Spring Shell CLI skeleton that other features build upon.
  
### F1.1 Project bootstrap (Maven + Spring Boot + Spring Shell) ✔️ RELEASED

- **Dependencies:** 
  <!-- May be empty -->
- **Project Requirements:** 
  - R1 CLI scaffold and runtime
  - R7 Non-functional requirements

Initialize a Java 21 Maven project with Spring Boot and Spring Shell, runnable entrypoint, basic app metadata, and comprehensive testing infrastructure.

**ENHANCED (2025-08-28)**: Added dual testing strategy with unit tests (fast, mocked) and integration tests (full Spring context).

- **Links:**
  - [Feature Specification](./backlog/f1.1.spec.md)
  - [Design Document](./backlog/f1.1.design.md)
  - [Implementation Plan](./backlog/f1.1.plan.md)
  - [Test Notes](./backlog/f1.1.test.md) ✅ **ENHANCED**
  - [Structure Overview](./STRUCTURE.md) ✅ **UPDATED**

### F1.2 Command framework and help system ✔️ RELEASED

- **Dependencies:** 
  - F1.1 Project bootstrap
- **Project Requirements:** 
  - R1 CLI scaffold and runtime

Expose a help system and command discovery with Spring Shell annotations, including app banner and version.

- **Links:**
  - [Feature Specification](./backlog/f1.2.spec.md)
  - [Design Document](./backlog/f1.2.design.md)
  - [Implementation Plan](./backlog/f1.2.plan.md)
  - [Test Notes](./backlog/f1.2.test.md) ✅

### F1.3 Configuration via environment variables ✔️ RELEASED

- **Dependencies:** 
  - F1.1 Project bootstrap
- **Project Requirements:** 
  - R3 Configuration via environment variables

Bind environment variables with sensible defaults (timeouts, log level, endpoints) using Spring config properties.

- **Links:**
  - [Feature Specification](./backlog/f1.3.spec.md)
  - [Design Document](./backlog/f1.3.design.md)
  - [Implementation Plan](./backlog/f1.3.plan.md)
  - [Test Notes](./backlog/f1.3.test.md) ✅

### F1.4 Structured logging baseline ✔️ RELEASED

- **Dependencies:** 
  - F1.1 Project bootstrap
- **Project Requirements:** 
  - R4 Monitoring and logging

Configure SLF4J-compatible logging with JSON-friendly patterns and log level control via env vars.

- **Links:**
  - [Feature Specification](./backlog/f1.4.spec.md)
  - [Design Document](./backlog/f1.4.design.md)
  - [Implementation Plan](./backlog/f1.4.plan.md)
  - [Test Notes](./backlog/f1.4.test.md) ✅

### F1.5 Exit codes and process lifecycle ✔️ RELEASED

- **Dependencies:** 
  - F1.2 Command framework and help system
- **Project Requirements:** 
  - R1 CLI scaffold and runtime
  - R7 Non-functional requirements

Standardize success and error exit codes, with consistent user-facing messages on failures.

- **Links:**
  - [Feature Specification](./backlog/f1.5.spec.md)
  - [Design Document](./backlog/f1.5.design.md)
  - [Implementation Plan](./backlog/f1.5.plan.md)
  - [Test Notes](./backlog/f1.5.test.md) ✅

## E2 Networking and Integrations Foundation ‼️ Critical

- Establish robust HTTP client configuration and external API endpoints to support integrations.

### F2.1 Reactive HTTP client with timeouts ✔️ RELEASED

- **Dependencies:** 
  - F1.1 Project bootstrap
  - F1.3 Configuration via environment variables
- **Project Requirements:** 
  - R3 Configuration via environment variables
  - R7 Non-functional requirements

Provide a WebClient bean with connect/read timeouts and sensible defaults, honoring env-driven configuration.

- **Links:**
  - [Feature Specification](./backlog/f2.1.spec.md)
  - [Design Document](./backlog/f2.1.design.md)
  - [Implementation Plan](./backlog/f2.1.plan.md) ✅ **UPDATED**
  - [Test Notes](./backlog/f2.1.test.md) ✅

### F2.2 External endpoints configuration (ip-api, Open‑Meteo) ✔️ RELEASED

- **Dependencies:** 
  - F1.3 Configuration via environment variables
- **Project Requirements:** 
  - R3 Configuration via environment variables

Expose configurable base URLs for IP Geolocation and Open‑Meteo services; validate formats.

- **Links:**
  - [Feature Specification](./backlog/f2.2.spec.md)
  - [Design Document](./backlog/f2.2.design.md)
  - [Implementation Plan](./backlog/f2.2.plan.md)
  - [Test Notes](./backlog/f2.2.test.md) ✅

## E3 Weather Command (Sample Feature) ❗ High

- Deliver a user-facing `weather` command that resolves location and prints current conditions.

### F3.1 Resolve location via IP (ip-api.com) ✔️ RELEASED

- **Dependencies:** 
  - F2.1 Reactive HTTP client with timeouts
  - F2.2 External endpoints configuration (ip‑api, Open‑Meteo)
- **Project Requirements:** 
  - R2 Weather command (sample feature)
  - R7 Non-functional requirements

When coordinates aren’t provided, call IP Geolocation API and map response to a Location object.

- **Links:**
  - [Feature Specification](./backlog/f3.1.spec.md)
  - [Design Document](./backlog/f3.1.design.md)
  - [Implementation Plan](./backlog/f3.1.plan.md)
  - [Test Notes](./backlog/f3.1.test.md) ✅
  - [Structure Overview](./STRUCTURE.md) ✅ **UPDATED**

### F3.2 Fetch current weather from Open‑Meteo ✔️ RELEASED

- **Dependencies:** 
  - F2.1 Reactive HTTP client with timeouts
  - F2.2 External endpoints configuration (ip‑api, Open‑Meteo)
- **Project Requirements:** 
  - R2 Weather command (sample feature)

Call Open‑Meteo with lat/lon and parse JSON into a WeatherObservation domain object.

- **Links:**
  - [Feature Specification](./backlog/f3.2.spec.md)
  - [Design Document](./backlog/f3.2.design.md)
  - [Implementation Plan](./backlog/f3.2.plan.md)
  - [Structure Overview](./STRUCTURE.md) ✅ **UPDATED**

### F3.3 Compose human‑readable weather report ✔️ RELEASED

- **Dependencies:** 
  - F3.1 Resolve location via IP (ip-api.com)
  - F3.2 Fetch current weather from Open‑Meteo
- **Project Requirements:** 
  - R2 Weather command (sample feature)

Transform domain objects into a concise terminal summary and print results.

- **Links:**
  - [Feature Specification](./backlog/f3.3.spec.md)
  - [Design Document](./backlog/f3.3.design.md)
  - [Implementation Plan](./backlog/f3.3.plan.md)
  - [Structure Overview](./STRUCTURE.md) ✅ **UPDATED**

### F3.4 Graceful errors and exit codes ✔️ RELEASED

- **Dependencies:** 
  - F1.5 Exit codes and process lifecycle
  - F2.1 Reactive HTTP client with timeouts
- **Project Requirements:** 
  - R2 Weather command (sample feature)
  - R7 Non-functional requirements

Handle network failures and upstream errors with clear messages and non‑zero exit codes.

- **Links:**
  - [Feature Specification](./backlog/f3.4.spec.md)
  - [Design Document](./backlog/f3.4.design.md)
  - [Implementation Plan](./backlog/f3.4.plan.md)
  - [Structure Overview](./STRUCTURE.md) ✅ **UPDATED**

## E4 Build and Packaging ❕ Normal

- Ensure predictable local builds and a runnable artifact for distribution.

### F4.1 Maven build plugins configuration ✔️ RELEASED

- **Dependencies:** 
  - F1.1 Project bootstrap
- **Project Requirements:** 
  - R7 Non-functional requirements

Configure Maven plugins (compiler, Surefire/Failsafe placeholders) and Java 21 toolchain for consistent builds.

- **Links:**
  - [Feature Specification](./backlog/f4.1.spec.md) ✅
  - [Design Document](./backlog/f4.1.design.md) ✅
  - [Implementation Plan](./backlog/f4.1.plan.md) ✅
  - [Implementation Tasks](./backlog/f4.1.tasks.md) ✅
  - [Test Notes](./backlog/f4.1.test.md) ✅

### F4.2 Runnable JAR packaging ✔️ RELEASED

- **Dependencies:** 
  - F4.1 Maven build plugins configuration
- **Project Requirements:** 
  - R1 CLI scaffold and runtime
  - R7 Non-functional requirements

Package the application as a self-contained executable JAR with Spring Boot plugin.

- **Links:**
  - [Feature Specification](./backlog/f4.2.spec.md) ✅
  - [Design Document](./backlog/f4.2.design.md) ✅
  - [Implementation Plan](./backlog/f4.2.plan.md) ✅
  - [Implementation Tasks](./backlog/f4.2.tasks.md) ✅
  - [Test Notes](./backlog/f4.2.test.md) ✅

## Additional Information

- [Git repository](https://github.com/AIDDbot/ArchetypeJavaCLI)
- [PRD Document](./PRD.md)
- [DOMAIN Models](./DOMAIN.md)
- [SYSTEMS Architecture](./SYSTEMS.md)

> End of BACKLOG for Archetype Java CLI, last updated 2025-08-27.
