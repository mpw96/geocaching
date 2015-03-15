package mpw96;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Unit test for simple App.
 */

@RunWith(Parameterized.class)
public class PieceTest {
	private int pieceIndex;
	private int rotation;

	public PieceTest(Integer _pieceIndex, Integer _rotation) {
		pieceIndex = _pieceIndex.intValue();
		rotation=_rotation;
	}

	private void printPiece(Piece p) {
		int width = p.getWidth();
		int height = p.getHeight();

		System.out.println(">>>>>>>>>>>>> " + p.getIndex());
		for (int y = height - 1; y >= 0; --y) {
			for (int x = 0; x < width; ++x) {
				System.out.print(p.getSnakeAt(x, y) ? "S" : "O");
			}
			System.out.println();
		}
	}

	@Parameterized.Parameters
	public static Iterable<Object[]> pieceData() {
		
		List<Object[]> all = new ArrayList<Object[]>();
		
		for(int x=0; x<Piece.pieces.length; ++x) {
			for(int rot=0; rot<4; ++rot) {
				// pieceindex, rotation state
				all.add(new Integer[] {x, rot});
			}
		}
		
		return all;
	}

	@Test
	public void testPrintIt() {
		Piece p = Piece.pieces[pieceIndex];
		for(int r=rotation; r>0; --r) {
			assertTrue(p.rotate());
		}
		
		printPiece(p);
		p.resetRotateState();
		System.out.println();
	}
}
