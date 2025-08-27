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

@SpringBootApplication
public class ArchetypeJavaCliApplication {

  private static final Logger log = LoggerFactory.getLogger(ArchetypeJavaCliApplication.class);

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(ArchetypeJavaCliApplication.class);
    app.setBannerMode(Banner.Mode.CONSOLE);
    app.run(args);
  }

  @Bean
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
