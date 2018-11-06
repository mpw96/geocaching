package mpw96;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class BoardTest
{
    @Test
    public void testEmptyBoard()
    {
        assertFalse(new Board().hasGoodPlacement());
    }
}
