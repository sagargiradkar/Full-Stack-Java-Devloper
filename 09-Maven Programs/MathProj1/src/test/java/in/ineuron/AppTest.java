package in.ineuron;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    /**
     * Test cases for the add method in App class
     */

    public void testAdditionOfTwoPositiveNumbers() {
        App app = new App();
        int result = app.add(10, 20);
        assertEquals(30, result);
    }

    public void testAdditionOfPositiveAndNegativeNumber() {
        App app = new App();
        int result = app.add(10, -5);
        assertEquals(5, result);
    }

    public void testAdditionOfTwoNegativeNumbers() {
        App app = new App();
        int result = app.add(-10, -20);
        assertEquals(-30, result);
    }

    public void testAdditionWithZero() {
        App app = new App();
        int result = app.add(10, 0);
        assertEquals(10, result);
    }

    public void testAdditionOfLargeNumbers() {
        App app = new App();
        int result = app.add(1000000, 2000000);
        assertEquals(3000000, result);
    }
}
