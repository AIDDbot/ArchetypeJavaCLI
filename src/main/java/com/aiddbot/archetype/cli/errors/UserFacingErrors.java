package com.aiddbot.archetype.cli.errors;

import com.aiddbot.archetype.cli.runtime.CodedException;

public final class UserFacingErrors {

  private UserFacingErrors() {}

  public static String format(Throwable t) {
    if (t == null) return "Unknown error";
    if (t instanceof CodedException ce) {
      return "ERROR: " + ce.getMessage();
    }
    String m = t.getMessage();
    return (m == null || m.isBlank()) ? "ERROR: " + t.getClass().getSimpleName() : "ERROR: " + m;
  }
}
