---
description: "Spring Shell best practices and usage guidelines"
applyTo: "**/*.java"
---

# Spring Shell Instructions

## Setup

- Add `spring-shell-starter` alongside Spring Boot.
- For interactive CLIs, set `spring.main.web-application-type=none`.
- Keep commands in a dedicated `cli` or `shell` feature package.

## Core Concepts

- Commands: Annotated methods in `@ShellComponent` classes (e.g., `@ShellMethod`).
- Availability: Use `@ShellMethodAvailability` to enable/disable commands.
- Parameter parsing: Simple types auto-converted; use option names for clarity.
- Built-ins: `help`, `exit/quit` may be available depending on version.

## Best Practices

- Start with no custom commands in bootstrap; add commands per feature.
- Keep command methods small; delegate to services for logic.
- Provide helpful descriptions and option names; keep output concise.
- Avoid blocking I/O in commands; if needed, encapsulate and show progress.
- Use validation on inputs; fail fast with clear messages.

## Examples

```java
@ShellComponent
class HelloCommands {
  @ShellMethod(key = "hello", value = "Greets by name")
  String hello(@ShellOption(defaultValue = "world") String name) {
    return "Hello, " + name + "!";
  }
}
```
