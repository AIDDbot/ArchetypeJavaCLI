package com.aiddbot.archetype.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * Spring Boot application entrypoint for the Archetype Java CLI.
 * <p>
 * Provides a minimal CLI-ready bootstrap with a startup log line including
 * application name and version.
 */
@SpringBootApplication
public class ArchetypeJavaCliApplication {

  private static final Logger log = LoggerFactory.getLogger(ArchetypeJavaCliApplication.class);

  /**
   * Application entrypoint for the Archetype Java CLI.
   * <p>
   * Boots a Spring Boot application configured for CLI usage (non-web) and prints
   * a simple banner to the console.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(ArchetypeJavaCliApplication.class);
    app.setBannerMode(Banner.Mode.CONSOLE);
    app.run(args);
  }

  @Bean
  /**
   * Logs a concise startup line with application name and version once the
   * Spring context has initialized.
   *
   * <p>Version is resolved from {@link BuildProperties} when available
   * (packaged builds), otherwise falls back to the optional property
   * {@code app.version} or {@code dev}.
   *
   * @param env Spring {@link Environment} to resolve config properties
   * @param buildProps lazy provider for build metadata
   * @return a runner executed at startup
   */
  CommandLineRunner logStartup(Environment env, ObjectProvider<BuildProperties> buildProps) {
    return args -> {
      String appName = env.getProperty("spring.application.name", "archetype-java-cli");
      String version = buildProps.getIfAvailable() != null
          ? buildProps.getIfAvailable().getVersion()
          : env.getProperty("app.version", "dev");
      log.info("{} v{} ready", appName, version);
    };
  }
}
