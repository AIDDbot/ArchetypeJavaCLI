---
description: "Spring Boot best practices and usage guidelines"
applyTo: "**/*.java"
---

# Spring Boot Instructions

## Setup

- Use Java 21 and Maven 3.9+.
- Prefer Spring Boot BOM via parent or dependencyManagement for consistent versions.
- Keep a minimal dependency set; add starters as features require them.
- Enable Maven Toolchains to enforce JDK 21.

## Core Concepts

- Auto-configuration: Boot wires common infrastructure based on classpath.
- Application class: `@SpringBootApplication` with a `main(String[] args)` entrypoint.
- Configuration: `application.properties` or `application.yml` with relaxed binding.
- Lifecycle: Use `ApplicationRunner`/`CommandLineRunner` for startup hooks.
- Logging: SLF4J abstraction with Logback default; control via `logging.level.*`.

## Best Practices

- Keep the application class in a top-level package to enable component scanning.
- Externalize configuration; avoid hardcoding values in code.
- Fail fast on misconfiguration; validate config with `@ConfigurationProperties` and JSR‑303.
- Prefer constructor injection and final fields; avoid field injection.
- Keep starters focused; avoid unnecessary transitive deps.
- For CLI apps, disable web stack unless needed (`spring.main.web-application-type=none`).
- Use `build-info` or resource filtering to expose version/build metadata.
- Structure by feature (screaming architecture) instead of by layer.

## Examples

```java
@SpringBootApplication
public class ArchetypeJavaCliApplication {
  public static void main(String[] args) {
    SpringApplication.run(ArchetypeJavaCliApplication.class, args);
  }
}
```

```properties
# application.properties
spring.application.name=archetype-java-cli
spring.main.web-application-type=none
```
