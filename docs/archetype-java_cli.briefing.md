# Archetype Java CLI Briefing

This project is an archetype for building Spring-Shell command-line interfaces (CLI) using Java. 
It provides a structured setup with essential tools and configurations to streamline development.
It includes a simple set of features to serve as a sample and guide for creating your own CLI applications.
It is not intended for production use, but rather as a learning tool and a starting point for your own projects.

## Features

The archetype provides a set of core and sample business features to facilitate the development of CLI applications.

### Core Features

- **Environment Variables**: 
- **Monitoring and Logging**: 

### Business Features

- **Weather Command**: Fetches and displays weather information based on current ip latitude and longitude in when invoked with `--weather`.

## Technology Stack

- **Java Support**: Built using Java 19 or 21, providing safety and modern features.
- **Configuration Files**: Comes with configuration files ensuring code quality and consistency.
- **Testing Framework**: Set up with modern Java Spring Built-in test runner, no other dependencies required.
- **Command-Line Interface**: Includes a basic CLI setup that can be extended with additional commands and options.

### Tooling and developer dependencies

- **Spring boot**: 
- **Java 21**: Used for writing the CLI application with type safety.
- **maven 3.9.11**: Helps manage and update dependencies.
 
All dependencies must be updatable to the latest version, and the project should be compatible with Node.js V24 LTS versions.

### Libraries and runtime dependencies



### Deprecated dependencies to avoid


### External Services

Used to enhance the functionality of the CLI with external data:

- **IP Geolocation API**: Used for determining the geographical location of the user's IP address. More information can be found at [IP Geolocation API](https://ip-api.com/).
- **Open Meteo API**: Utilized for fetching weather data based on geographical coordinates. More information can be found at [Open Meteo](https://open-meteo.com/).

## Maintenance

- Readme with installation and execution instructions.
- Docs folder with detailed documentation on the CLI's development, features and usage.
- Source code folder structure and organization.
- Java Doc comments for public method and classes.
- Unit tests for public method and classes related to sample features.
- E2E tests for the CLI commands.
- Just to be executed on the development environment.

---

- **Author**: Alberto Basalo
  - [X/@albertobasalo](https://x.com/albertobasalo)
  - [LinkedIn](https://www.linkedin.com/in/albertobasalo/)
  - [GitHub](https://github.com/albertobasalo)
  - [Sitio personal](https://albertobasalo.dev)
  - [Cursos en Español en AI code Academy](https://aicode.academy)
- **Project**: AIDDbot
  - [AIDDbot.com blog](https://aiddbot.com)
  - [GitHub/AIDDbot org](https://github.com/AIDDbot)
  - [GitHub/AIDDbot/ArchetypeNodeCLI repo](https://github.com/AIDDbot/ArchetypeNodeCLI)