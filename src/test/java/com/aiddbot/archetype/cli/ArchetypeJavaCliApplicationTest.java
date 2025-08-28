package com.aiddbot.archetype.cli;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

/**
 * Integration test for ArchetypeJavaCliApplication.
 * <p>
 * This test starts the ENTIRE Spring context - it's SLOW but tests real
 * integration.
 * For fast tests, use ArchetypeJavaCliApplicationUnitTest instead.
 */
@SpringBootTest(classes = ArchetypeJavaCliApplication.class, webEnvironment = WebEnvironment.NONE, properties = {
    "spring.autoconfigure.exclude=org.springframework.shell.boot.ShellAutoConfiguration"
})
@ActiveProfiles("test")
@TestPropertySource(properties = {
    "spring.shell.interactive.enabled=false",
    "spring.shell.noninteractive.enabled=false",
    "spring.main.web-application-type=none",
    "spring.main.banner-mode=off",
    "logging.level.com.aiddbot=DEBUG",
    "logging.level.org.springframework.shell=DEBUG"
})
class ArchetypeJavaCliApplicationTest {

  private static final Logger log = LoggerFactory.getLogger(ArchetypeJavaCliApplicationTest.class);

  @Test
  void contextLoads() {
    log.info("=== INTEGRATION TEST STARTING: contextLoads ===");
    log.info("Spring context has loaded successfully - this means:");
    log.info("1. All Spring beans have been created");
    log.info("2. Configuration has been loaded");
    log.info("3. Application is ready (but Shell is disabled for testing)");
    // Intentionally empty: verifies the Spring context starts successfully.
    log.info("=== INTEGRATION TEST COMPLETED: contextLoads ===");
  }
}
