package mpw96;

public class Tree {

	public static void main(String[] args) {
		
		Board board = new Board();
		
		if( args[0].equals("text")) {
			new Tree(board, new TextSolutionPresenter(board)).go();
		}
		else {
			new Tree(board, new GraphicSolutionPresenter(board)).go();
		}
	}

	private Board board;
	private SolutionPresenter solutionPresenter;
	
	public Tree(Board _board, SolutionPresenter _solutionPresenter) {
		board = _board;
		solutionPresenter = _solutionPresenter;
	}
	
 	class PiecePosition {

		final private int pieceIndex;
		
		boolean isPlaced = false;
		private int x=0;
		private int y=0;
		
		private void resetPosition() {
			x=0;
			y=0;
		}
		
		public void printPosition() {
			Tree.this.solutionPresenter.printPosition(pieceIndex, x, y);
		}
		
		private boolean incrementPosition() {
			
			do {
				if( y<12-Piece.pieces[pieceIndex].getWidth()) {
					++y;
					return true;
				}
				
				if( x<4-Piece.pieces[pieceIndex].getHeight()) {
					++x;
					y=0;
					return true;
				}
				
				if(Piece.pieces[pieceIndex].rotate()) {
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
		
		public PiecePosition(int _pieceIndex) {
			pieceIndex=_pieceIndex;
		}
		
		boolean placeIt() {
			if(isPlaced) {
				Tree.this.board.removePieceFrom(x, y, Piece.pieces[pieceIndex]);
				isPlaced=false;
				if(!incrementPosition()) {
					Piece.pieces[pieceIndex].resetRotateState();
					return false;
				}
			}

			do {
				isPlaced=Tree.this.board.placePieceAt(x, y, Piece.pieces[pieceIndex]);
			} while(!isPlaced && incrementPosition());
			
			return isPlaced;
		}
	}
	
	public void go() {
		
		PiecePosition pp[] = new PiecePosition[9]; 
		for(int i=0; i<9; ++i) {
			pp[i] = new PiecePosition(i);
		}
		
		int placing=0;
		while( true ) {
			solutionPresenter.printLoopInfo(placing);
			if(pp[placing].placeIt()) {
				if(8==placing) {
					solutionPresenter.printSolution(pp);
					return;
				}
				
				++placing;
				pp[placing].resetPosition();
				Piece.pieces[placing].resetRotateState();
			}
			else
			{
				if(0==placing) {		
					solutionPresenter.printNoSolution();
					return;
				}
				--placing;
			}
		}
	}
}
