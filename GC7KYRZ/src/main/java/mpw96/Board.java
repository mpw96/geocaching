package mpw96;

public class Board {

	private static final int rawdata[][] = {
		{6,6,1,4,6,3,0,4},
		{3,5,1,2,2,2,1,1},
		{3,6,5,5,2,4,5,2},
		{1,1,4,2,6,0,4,0},
		{5,1,4,4,3,3,2,0},
		{1,4,0,0,5,5,3,6},
		{6,6,5,2,3,3,0,0}
	};

	public Board() {
		init();
	}

    // erst Zeile, dann Spalte
	//      y           x
	
    private Cell[][] boardImpl = new Cell[7][8];

	public void init() {
		for (int x = 0; x < 8; ++x) {
			for (int y = 0; y < 7; ++y) {
				boardImpl[y][x] = new Cell(rawdata[y][x]);
			}
		}
	}

	public void removePiece(Piece p) {
		for (int x = 0; x < 8; ++x) {
			for (int y = 0; y < 7; ++y) {
				if( boardImpl[y][x].getOccupyingPiece() == p.getIndex() ) {
					boardImpl[y][x].makeEmpty();
				}
			}
		}
	}

		// 0, rechts
		// 1, unten
		// 2, links
		// 3, oben

	public boolean placePieceAt(int x, int y, Piece p) {
		Cell cellForOne = boardImpl[y][x];
		if( cellForOne.isOccupied() || cellForOne.getValue() != p.getValueOne() ) {
			return false;
		}
		int rotate = p.getWhereIsTwo();
		Cell cellForTwo;
		if( rotate==0 ) {
			cellForTwo = boardImpl[y][x+1];
		}
		else if(rotate==1 ) {
			cellForTwo = boardImpl[y-1][x];
		}
		else if(rotate==2 ) {
			cellForTwo = boardImpl[y][x-1];
		}
		else {
			cellForTwo = boardImpl[y+1][x];
		}

		if( !cellForTwo.isOccupied() && cellForTwo.getValue() == p.getValueTwo() ) {
			// can place it
			cellForOne.occupy(p.getIndex());
			cellForTwo.occupy(p.getIndex());
			return true;
		}

		return false;
	}
}
