package mpw96;

public class Cell {
	private int occupyingPiece;
	private boolean isSnake;
	
	public Cell() {
		occupyingPiece=-1;
		isSnake=false;
	}
	
	public boolean isOccupied() {
		return occupyingPiece>-1;
	}
	
	public int getOccupyingPiece() {
		return occupyingPiece;
	}
	
	public boolean isSnake() {
		return isOccupied() && isSnake;
	}
	
	public void makeEmpty() {
		occupyingPiece=-1;
		isSnake=false;
	}
	
	public void occupy(int pieceIndex) {
		occupyingPiece=pieceIndex;
		isSnake=false;
	}
	
	public void setSnake(int pieceIndex) {
		occupyingPiece=pieceIndex;
		isSnake=true;
	}
}
