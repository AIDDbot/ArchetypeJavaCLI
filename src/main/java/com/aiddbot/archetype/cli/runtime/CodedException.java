package com.aiddbot.archetype.cli.runtime;

/**
 * Exception carrying an exit code to signal specific failure scenarios to the process boundary.
 */
public final class CodedException extends RuntimeException {
  private final ExitCodes exitCode;

  public CodedException(ExitCodes exitCode, String message) {
    super(message);
    this.exitCode = exitCode;
  }

  public CodedException(ExitCodes exitCode, String message, Throwable cause) {
    super(message, cause);
    this.exitCode = exitCode;
  }

  public ExitCodes getExitCode() {
    return exitCode;
  }
}
