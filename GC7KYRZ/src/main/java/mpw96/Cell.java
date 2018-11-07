package mpw96;

public class Cell {
	private int value;
	private int occupyingPiece;
	
	public Cell(int _value) {
		occupyingPiece=-1;
		value=_value;
	}

	public int getValue() {
		return value;
	}
	public boolean isOccupied() {
		return occupyingPiece>-1;
	}
	
	public int getOccupyingPiece() {
		return occupyingPiece;
	}
		
	public void makeEmpty() {
		occupyingPiece=-1;
	}
	
	public void occupy(int pieceIndex) {
		occupyingPiece=pieceIndex;
	}	
}
