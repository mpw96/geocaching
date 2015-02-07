package gc2f1mv;

public class TextSolutionPresenter implements SolutionPresenter {

	private Board board;
	
	public TextSolutionPresenter(Board _b) {
		board=_b;
	}
	
	public void printPosition(int pieceIndex, int x, int y) {
		System.out.println("piece "+pieceIndex+": x="+x+", y="+y+", rotate: "+Piece.pieces[pieceIndex].getRotateState());
	}

	public void printLoopInfo(int placingPiece) {
		System.out.println("placing: " + placingPiece);
		board.print();
		System.out.println();
	}

	public void printSolution(Tree.PiecePosition pp[]) {
		System.out.println("solution");
		board.print();
		for(int i=0; i<9; ++i) {
			Piece.pieces[i].print();
			pp[i].printPosition();
		}
	}

	public void printNoSolution() {
		System.out.println("no solution");
	}
}
