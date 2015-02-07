package gc2f1mv;

public interface SolutionPresenter {
	
	public void printPosition(int pieceIndex, int x, int y);
	public void printLoopInfo(int placingPiece);
	public void printSolution(Tree.PiecePosition pp[]);
	public void printNoSolution();
}
