package com.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */

public class AppTest 
{
    // Set up tests using the following annotations:
    // BeforeAll and AfterAll must be static if not using the
    // TestInstance(TestInstance(Lifecycle.PER_CLASS) for the test class

    // BeforeAll runs once before any tests begin.
    // Sets up necessary resources for the entire test portion (i.e. database connection)
    @BeforeAll
    public static void classSetup() {
        System.out.println("BeforeAll");
        testHelper();
    }

    // BeforeEach runs once before every single test.
    // Setups up necessary resources for the method (i.e. a fresh generic dataset)
    @BeforeEach
    public void methodSetup() {
        System.out.println("BeforeEach");
    }

    // AfterEach runs after every single test.
    // Generally used to clear mock dataset to discard side effects methods may have
    @AfterEach
    public void methodTeardown() {
        System.out.println("AfterEach");
    }

    // AfterAll runs after every single test has been concluded
    // Closes resources used for the testing class (i.e. closing database connections)
    @AfterAll
    public static void classTeardown() {
        System.out.println("AfterAll");
    }

    // Multiple annotations for each setup step is valid, but there are no
    // guarantees of run order of methods within the same setup stage
    // Generally discouraged because of this - instead use helper methods:
    private static void testHelper() {
        System.out.println("This is a friendly test helper!");
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    // Tests with the @Disabled annotation are skipped in the testing phase
    // Preferred to deletion as you may eventually want to revisit in the future.
    @Test
    @Disabled
    public void disabledTest() {
        assertTrue(false);
    }
}
