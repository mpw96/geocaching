package mpw96;

public class Piece {

	final private int index;

	final private int value_one;
	final private int value_two;

	private int where_is_two; // 0, rechts
							  // 1, unten
							  // 2, links
							  // 3, oben

	
	private Piece(int _index, int _value_one, int _value_two) {
		index=_index;
		where_is_two = 0;
		value_one = _value_one;
		value_two = _value_two;
	}

	public int getIndex() {
		return index;
	}
	
	public int getValueOne() {
		return value_one;
	}

	public int getValueTwo() {
		return value_two;
	}

	public int getWhereIsTwo() {
		return where_is_two;
	}

	public void resetRotateState() {
		where_is_two = 0;
	}
	
	public boolean rotate() {
		
		if(3==where_is_two) {
			return false;
		}
		
		++where_is_two;
		
		return true;
	}
	
    public void print() {
		System.out.println("(" + value_one + ", " + value_two + "): " + where_is_two);
    }

	public static Piece pieces[] = new Piece[28];

	static {
		int pieceIndex=0;
		for (int left = 0; left < 7; ++left) {
			for(int right = 0; right <= left; ++right) {
				pieces[pieceIndex] = new Piece(pieceIndex, left, right);
                ++pieceIndex;
			}
		}

	}
}
