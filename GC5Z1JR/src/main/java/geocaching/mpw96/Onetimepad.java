package geocaching.mpw96;

public class Onetimepad {
	int[][] key = new int[24][2];
	int positionState = 0;
	
	public void set(int index, int value) {
		int row = index / 2;
		int column = index % 2;

		key[row][column] = value;
	}
	
	public int getKeyLetter(int index) {
		int row = index / 2;
		int column = index % 2;
		
		return key[row][column];
	}
	
	private void mirrorHorizontally() {
		int[] tmp = new int[2];
		for(int i=0; i<12; ++i) {
			tmp[0] = key[23-i][0];
			tmp[1] = key[23-i][1];
			key[23-i][0] = key[i][0];
			key[23-i][1] = key[i][1];
			key[i][0] = tmp[0];
			key[i][1] = tmp[1];
		}
	}

	private void mirrorVertically() {
		for(int i=0; i<23; ++i) {
			int tmp = key[i][0];
			key[i][0] = key[i][1];
			key[i][1] = tmp;
		}
	}

	public boolean hasNextPosition() {
		return positionState<3;
	}

	public int getCurrentPosition() {
		return positionState;
	}
	
	public void nextPosition() {
		if(0==positionState) {
			mirrorHorizontally();
			positionState = 1;
		}
		else if(1==positionState) {
			mirrorHorizontally();
			mirrorVertically();
			positionState = 2;
		}		
		else if(2==positionState) {
			mirrorHorizontally();
			positionState = 3;
		}		
	}
}
