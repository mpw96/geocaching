package gc2f1mv;

public class Board {

	private int boardImpl[][] = new int[4][12];

	public Board() {
		init();
	}

	public void init() {
		for (int x = 0; x < 4; ++x) {
			for (int y = 0; y < 12; ++y) {
				boardImpl[x][y] = 0;
			}
		}
		boardImpl[0][0] = 1;
	}

	public int getCell(int x, int y) {
		return boardImpl[x][y];
	}
	
	public void print() {
		for (int x = 3; x >= 0; --x) {
			for (int y = 0; y < 12; ++y) {
				System.out.print(boardImpl[x][y]);
			}
			System.out.println();
		}
	}

	public boolean hasGoodPlacement() {
		boolean rc = true;

		// all places on board occupied
		for (int x = 0; rc && x < 4; ++x) {
			for (int y = 0; rc && y < 12; ++y) {
				rc = rc && boardImpl[x][y] >= 1;
			}
		}

		return rc;
	}

	public boolean placePieceAt(int x, int y, Piece piece) {
		
		// check
		for (int px=0; px<piece.getHeight(); ++px) {
			for (int py = 0; py<piece.getWidth(); ++py) {
				if( piece.getValueAt(px, py) >= 1 ) {
					if (x+px>3 || y+py>11 || boardImpl[x+px][y+py] >= 1) {
						return false;
					}
				}
			}
		}

		// place
		for (int px=0; px<piece.getHeight(); ++px) {
			for (int py = 0; py<piece.getWidth(); ++py) {
				if( piece.getValueAt(px, py) >= 1 ) {
					boardImpl[x+px][y+py] = piece.getValueAt(px, py);
				}
			}
		}

		return true;
	}

	public void removePieceFrom(int x, int y, Piece piece) {
		for (int px = 0; px < piece.getHeight(); ++px) {
			for (int py = 0; py < piece.getWidth(); ++py) {
				if( piece.getValueAt(px, py) >= 1 ) {
					boardImpl[x+px][y+py] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Board b = new Board();
		b.print();
		System.out.println();
		
		b.placePieceAt(0, 1, Piece.pieces[3]);
		b.print();
		System.out.println();
		b.removePieceFrom(0, 1, Piece.pieces[3]);
		b.print();
		System.out.println();

	}
}
