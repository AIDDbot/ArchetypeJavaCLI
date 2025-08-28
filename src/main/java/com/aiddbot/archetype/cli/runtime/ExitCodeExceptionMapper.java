package com.aiddbot.archetype.cli.runtime;

/** Maps exceptions to exit codes and messages. */
public interface ExitCodeExceptionMapper {
  int map(Throwable t);

  /** Returns a concise, user-friendly message for the exception. */
  String message(Throwable t);
}
