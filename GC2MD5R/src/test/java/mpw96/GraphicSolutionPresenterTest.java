package mpw96;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class GraphicSolutionPresenterTest {

	@Before
    public void resetPieces() {
		for(int i=0; i<8; ++i) {
			Piece.pieces[i].resetRotateState();
		}
	}	
	
	@Test
	public void shouldDisplayOnePiece() {
		Board b = new Board();
		assertTrue(b.placePieceAt(3, 3, Piece.pieces[4]));
		new GraphicSolutionPresenter(b);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void shouldAcceptMatchingPiece() {
		Board b = new Board();
		assertTrue(b.placePieceAt(3, 3, Piece.pieces[1]));
		assertTrue(b.placePieceAt(3, 6, Piece.pieces[2]));
		new GraphicSolutionPresenter(b);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void shouldRejectMismatch() {
		Board b = new Board();
		assertTrue(b.placePieceAt(3, 3, Piece.pieces[1]));
		assertFalse(b.placePieceAt(3, 6, Piece.pieces[3]));
		new GraphicSolutionPresenter(b);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void shouldPlaceAtLeftBottom() {
		Board b = new Board();
		assertTrue(b.placePieceAt(0, 0, Piece.pieces[1]));
		new GraphicSolutionPresenter(b);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void shouldPlaceAtLeftTop() {
		Board b = new Board();
		assertTrue(Piece.pieces[1].rotate());
		assertTrue(b.placePieceAt(0, 6, Piece.pieces[1]));
		new GraphicSolutionPresenter(b);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void shouldPlaceAtRightTop() {
		Board b = new Board();
		assertTrue(Piece.pieces[1].rotate());
		assertTrue(Piece.pieces[1].rotate());
		assertTrue(b.placePieceAt(6, 9, Piece.pieces[1]));
		new GraphicSolutionPresenter(b);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void shouldPlaceAtRightBottom() {
		Board b = new Board();
		assertTrue(Piece.pieces[1].rotate());
		assertTrue(Piece.pieces[1].rotate());
		assertTrue(Piece.pieces[1].rotate());
		assertTrue(b.placePieceAt(6, 3, Piece.pieces[1]));
		new GraphicSolutionPresenter(b);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void shouldRejectSnakeAtBottomEdge() {
		Board b = new Board();
		assertFalse(b.placePieceAt(0, 0, Piece.pieces[5]));
		new GraphicSolutionPresenter(b);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void shouldRejectSnakeAtRightEdge() {
		Board b = new Board();
		assertFalse(b.placePieceAt(6, 3, Piece.pieces[5]));
		new GraphicSolutionPresenter(b);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
