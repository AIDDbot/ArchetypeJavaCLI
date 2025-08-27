package com.aiddbot.archetype.cli;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ArchetypeJavaCliApplication.class, properties = {
    "spring.main.web-application-type=none",
    "spring.shell.interactive.enabled=false",
    "spring.shell.noninteractive.enabled=false"
})
class ArchetypeJavaCliApplicationTest {

  @Test
  void contextLoads() {
    // If the application context fails to start, this test will fail.
    assertNotNull(ArchetypeJavaCliApplication.class);
  }
}
