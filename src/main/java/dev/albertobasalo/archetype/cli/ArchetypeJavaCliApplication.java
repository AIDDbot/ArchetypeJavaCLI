package dev.albertobasalo.archetype.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ArchetypeJavaCliApplication {

  private static final Logger log = LoggerFactory.getLogger(ArchetypeJavaCliApplication.class);

  @Value("${spring.application.name:archetype-java-cli}")
  private String appName;

  @Value("${app.version:dev}")
  private String appVersion;

  @Autowired(required = false)
  private BuildProperties buildProperties;

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(ArchetypeJavaCliApplication.class);
    app.setBannerMode(Banner.Mode.CONSOLE);
    app.run(args);
  }

  @Bean
  CommandLineRunner logStartup() {
    return args -> {
      String version = (buildProperties != null) ? buildProperties.getVersion() : appVersion;
      log.info("{} v{} ready", appName, version);
    };
  }
}
