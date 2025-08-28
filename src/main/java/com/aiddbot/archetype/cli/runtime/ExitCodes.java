package com.aiddbot.archetype.cli.runtime;

/**
 * Canonical process exit codes for the CLI.
 */
public enum ExitCodes {
  SUCCESS(0),
  VALIDATION(2),
  RUNTIME(3),
  IO(4),
  NETWORK(5),
  UNKNOWN(1);

  private final int code;

  ExitCodes(int code) {
    this.code = code;
  }

  public int code() {
    return code;
  }
}
