package gc2f1mv;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class BoardTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BoardTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BoardTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testEmptyBoard()
    {
        assertFalse(new Board().hasGoodPlacement());
    }
}
