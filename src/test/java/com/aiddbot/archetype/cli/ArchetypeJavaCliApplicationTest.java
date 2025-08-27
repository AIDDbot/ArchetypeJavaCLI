package com.aiddbot.archetype.cli;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(
  classes = ArchetypeJavaCliApplication.class)
@ActiveProfiles("test")
class ArchetypeJavaCliApplicationTest {

  @Test
  void contextLoads() {
    // If the application context fails to start, this test will fail.
    assertNotNull(ArchetypeJavaCliApplication.class);
  }
}
