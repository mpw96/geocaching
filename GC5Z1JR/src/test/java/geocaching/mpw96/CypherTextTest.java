package geocaching.mpw96;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CypherTextTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CypherTextTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CypherTextTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void test00()
    {
        assertEquals(Integer.parseInt("00111011", 2), new CypherText().getCypherLetter(0));
    }

    public void test01()
    {
        assertEquals(Integer.parseInt("00001110", 2), new CypherText().getCypherLetter(1));
    }

    public void test51()
    {
        assertEquals(Integer.parseInt("10010100", 2), new CypherText().getCypherLetter(11));
    }
}
