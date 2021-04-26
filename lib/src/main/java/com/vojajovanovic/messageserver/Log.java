package com.vojajovanovic.messageserver;

public class Log {
  public static boolean debug = false;

  public static void error(String message) {
    System.out.printf("\n\nERROR: %s\n\n", message);
  }

  public static void error(String format, Object... args) {
    System.out.printf(format, args);
  }

  public static void error(Exception error) {
    System.out.printf("\n\nERROR[%s]: %s\n\n", error.getClass().getName(),
                                               error.getMessage());
  }

  public static void info(String message) {
    System.out.println(message);
  }

  public static void info(String format, Object... args) {
    System.out.println("");
    System.out.printf(format, args);
  }

  public static void debug(String message) {
    if (debug) {
      System.out.println("");
      System.out.println(message);
    }
  }

  public static void debug(String format, Object... args) {
    if (debug) {
      System.out.println("");
      System.out.printf(format, args);
    }
  }
}