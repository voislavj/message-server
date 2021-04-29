package com.vojajovanovic.messageserver;

/**
 * Logger utility class
 */
public class Log {
  /**
   * indicates debug state
   */
  public static boolean debug = false;

  /**
   * Log error message
   *
   * @param message text to log
   */
  public static void error(String message) {
    System.out.printf("\n\nERROR: %s\n\n", message);
  }

  /**
   * Log error message
   *
   * @param format output format
   * @param args output format arguments
   */
  public static void error(String format, Object... args) {
    System.out.printf(format, args);
  }

  /**
   * Log error message
   *
   * @param error Exception instance
   */
  public static void error(Exception error) {
    System.out.printf("\n\nERROR[%s]: %s\n\n", error.getClass().getName(),
                                               error.getMessage());
  }

  /**
   * Log informational message
   *
   * @param message text to log
   */
  public static void info(String message) {
    System.out.println(message);
  }

  /**
   * Log informational message
   *
   * @param format output format
   * @param args output format arguments
   */
  public static void info(String format, Object... args) {
    System.out.println("");
    System.out.printf(format, args);
  }

  /**
   * Log debug message
   *
   * @param message text to log
   */
  public static void debug(String message) {
    if (debug) {
      System.out.println("");
      System.out.println(message);
    }
  }

  /**
   * Log debug message
   *
   * @param format output format
   * @param args output format arguments
   */
  public static void debug(String format, Object... args) {
    if (debug) {
      System.out.println("");
      System.out.printf(format, args);
    }
  }
}