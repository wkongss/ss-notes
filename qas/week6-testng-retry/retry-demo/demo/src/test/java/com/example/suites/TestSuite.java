package com.example.suites;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;

public class TestSuite {
  @Test
  public void testOne() {
    assertEquals(1 + 1, 2);
  }

  @Test
  public void testTwo() {
    // Should fail! Fix and retry with: mvn test -Pretry
    assertEquals(2 + 2, 5);
  }

  @Test
  public void testThree() {
    assertEquals(3 + 3, 6);
  }

  @Test
  public void testFour() {
    assertEquals(4 + 4, 8);
  }

  @Test
  public void testFive() {
    // Should fail! Fix and retry!
    assertEquals(5 + 5, 55);
  }
}