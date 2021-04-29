package com.vojajovanovic;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for MessageServer.
 */
public class MessageServerTest extends TestCase {

  /**
   * Create the test case
   *
   * @param testName name of the test case
   */
  public MessageServerTest(String testName) {
    super(testName);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(MessageServerTest.class);
  }

  /**
   * Rigourous Test :-)
   */
  public void testApp() {
    assertTrue(true);
  }
}
