package mpw96;

public class Tree {

	public static void main(String[] args) {
		
		Board b = new Board();
		new Tree(b).go();
	}

	private Board board;
	
	public Tree(Board _board) {
		board = _board;
	}
	
 	class PiecePosition {

		final private Piece piece;
		
		boolean isPlaced = false;
		private int x=0;
		private int y=0;
		
		private void resetPosition() {
			int rotate = piece.getWhereIsTwo();
			if( rotate == 0 ) {
				x=0;
				y=0;
			}
			else if( rotate==1 ) {
				x=0;
				y=1;
			}
			else if( rotate==2 ) {
				x=1;
				y=0;
			}
			else {
				x=0;
				y=0;
			}
		}
		
		public void printPosition() {
			System.out.println("beg==========================");
			System.out.println("x=" + x + ", y=" + y);
			piece.print();
			System.out.println("end==========================");
		}
		

		// 0, rechts
		// 1, unten
		// 2, links
		// 3, oben

		private boolean incrementPosition() {
			
			do {
				int rotate = piece.getWhereIsTwo();
				if( rotate==0 ) {
					if( x<6 ) {
						++x;
						return true;
					}
					if( y<6 ) {
						++y;
						x=0;
						return true;
					}
				}

				if( rotate==1 ) {
					if( x<7 ) {
						++x;
						return true;
					}
					if( y<6 ) {
						++y;
						x=0;
						return true;
					}
				}

				if( rotate==2 ) {
					if( x<7 ) {
						++x;
						return true;
					}
					if( y<6 ) {
						++y;
						x=1;
						return true;
					}
				}

				if( rotate==3 ) {
					if( x<7 ) {
						++x;
                        return true;
					}
					if( y<5 ) {
						++y;
						x=0;
						return true;
					}
				}

				if(piece.rotate()) {
					resetPosition();
					return true;
				}
				else {
					break;
				}
			}
			while (true);
			
			return false;
		}
		
		public PiecePosition(Piece _piece) {
			piece =_piece;
		}
		
		boolean placeIt() {
			if(isPlaced) {
				Tree.this.board.removePiece(piece);
				isPlaced=false;
				if(!incrementPosition()) {
					piece.resetRotateState();
					return false;
				}
			}

			do {
				isPlaced=Tree.this.board.placePieceAt(x, y, piece);
			} while(!isPlaced && incrementPosition());
			
			return isPlaced;
		}
	}
	
	public void go() {
		
		PiecePosition pp[] = new PiecePosition[28]; 
		for(int i=0; i<28; ++i) {
			pp[i] = new PiecePosition(Piece.pieces[i]);
		}
		
		int placing=0;
		while( true ) {
			if(pp[placing].placeIt()) {
				if(27==placing) {
					// fertig
					for(int i=0; i<28; ++i) {
						pp[i].printPosition();
					}
					return;
				}
				++placing;
				Piece.pieces[placing].resetRotateState();
				pp[placing].resetPosition();
			}
			else
			{
				if(0==placing) {
					// gibt keine Lösung		
					System.out.println("no solution");
					return;
				}
				--placing;
			}
		}
	}
}
