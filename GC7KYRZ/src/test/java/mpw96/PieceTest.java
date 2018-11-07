package mpw96;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PieceTest {

	private int pieceIndex;
	
	@Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
		    	{0},
     			{1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8},
                {9},
                {10},
                {11},
                {12},
                {13},
                {14},
                {15},
                {16},
                {17},
                {18},
                {19},
                {20},
                {21},
                {22},
                {23},
                {24},
                {25},
                {26},
                {27}
        });
    }
	public PieceTest(Integer _pieceIndex) {
		pieceIndex=_pieceIndex.intValue();
	}

	private void printPiece(Piece p) {
		p.print();
	}

	@Test
	public void testPrintIt() {
		Piece p = Piece.pieces[pieceIndex];
		printPiece(p);
		System.out.println();
	}
}
