package mpw96;

public class Board {

	private Cell boardImpl[][] = new Cell[12][12];

	public Board() {
		init();
	}

	public void init() {
		for (int x = 0; x < 12; ++x) {
			for (int y = 0; y < 12; ++y) {
				boardImpl[x][y] = new Cell();
			}
		}
	}

	public Cell getCell(int x, int y) {
		return boardImpl[x][y];
	}
	
	public boolean placePieceAt(int x, int y, Piece piece) {
		
		// check correct placing on board
		if( x+piece.getWidth()>12 || y+piece.getHeight()>12 || x%3!=0 || y%3!=0) {
			return false;
		}
		
		// check overlap with other pieces
		for (int px=0; px<piece.getWidth(); ++px) {
			for (int py = 0; py<piece.getHeight(); ++py) {
				if(boardImpl[x+px][y+py].isOccupied()) {
					return false;
				}
			}
		}

		//  check snake
		if(0==x) {
			// no snake allowed on left edge of board
			for(int py=0; py<piece.getHeight(); ++py) {
				if(piece.getSnakeAt(0, py)) {
					return false;
				}
			}
		}
		
		if(0==y) {
			// no snake allowed on bottom edge of board
			for(int px=0; px<piece.getWidth(); ++px) {
				if(piece.getSnakeAt(px, 0)) {
					return false;
				}
			}
		}
		
		if(12==x+piece.getWidth()) {
			// no snake allowed on right edge of board
			for(int py=0; py<piece.getHeight(); ++py) {
				if(piece.getSnakeAt(piece.getWidth()-1, py)) {
					return false;
				}
			}
		}
		
		if(12==y+piece.getHeight()) {
			// no snake allowed on top edge of board
			for(int px=0; px<piece.getWidth(); ++px) {
				if(piece.getSnakeAt(px, piece.getHeight()-1)) {
					return false;
				}
			}
		}

		// snake match above and below?
		int above=y+piece.getHeight();
		int below=y-1;
		for(int px=0; px<piece.getWidth(); ++px) {
			if(above<12&&boardImpl[x+px][above].isOccupied()&&piece.getSnakeAt(px, piece.getHeight()-1)!=boardImpl[x+px][above].isSnake()) {
				return false;
			}
			if(below>=0&&boardImpl[x+px][below].isOccupied()&&piece.getSnakeAt(px, 0)!=boardImpl[x+px][below].isSnake()) {
				return false;
			}
		}
		
		// snake match left and right?
		int right=x+piece.getWidth();
		int left=x-1;
		for(int py=0; py<piece.getHeight(); ++py) {
			if(right<12&&boardImpl[right][y+py].isOccupied()&&piece.getSnakeAt(piece.getWidth()-1, py)!=boardImpl[right][y+py].isSnake()) {
				return false;
			}
			if(left>=0&&boardImpl[left][y+py].isOccupied()&&piece.getSnakeAt(0, py)!=boardImpl[left][y+py].isSnake()) {
				return false;
			}
		}
		
		// place
		for (int px=0; px<piece.getWidth(); ++px) {
			for (int py=0; py<piece.getHeight(); ++py) {
				if(piece.getSnakeAt(px, py)) {
					boardImpl[x+px][y+py].setSnake(piece.getIndex());
				}
				else {
					boardImpl[x+px][y+py].occupy(piece.getIndex());
				}
			}
		}

		return true;
	}

	public void removePieceFrom(int x, int y, Piece piece) {
		for (int px=0; px<piece.getWidth(); ++px) {
			for (int py = 0; py<piece.getHeight(); ++py) {
				boardImpl[x+px][y+py].makeEmpty();
			}
		}
	}
}
