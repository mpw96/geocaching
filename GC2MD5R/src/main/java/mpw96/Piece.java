package mpw96;

public class Piece {

	final private int index;
	private boolean original[][] = new boolean[6][3];
	private int owidth = 6;
	private int oheight = 3;
	
	private boolean pieceImpl[][] = new boolean[6][3];
	private int width = owidth;
	private int height = oheight;
	private int rotateState=0;
	
	private Piece(int _index) {
		index=_index;
		init();
	}

	private void init() {
		for (int x = 0; x < owidth; ++x) {
			for (int y = 0; y < oheight; ++y) {
				pieceImpl[x][y] = false;
				original[x][y] = false;
			}
		}
	}

	public int getIndex() {
		return index;
	}
	
	public boolean getValueAt(int x, int y) {
		return pieceImpl[x][y];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void resetRotateState() {
		pieceImpl = new boolean[6][3];

		for (int x = 0; x < 6; ++x) {
			for (int y = 0; y < 3; ++y) {
				pieceImpl[x][y] = original[x][y];
			}
		}
		width = owidth;
		height = oheight;
		rotateState = 0;
	}
	
	public boolean rotate() {
		
		if(3==rotateState) {
			return false;
		}
		
		int h = getHeight();
		int w = getWidth();
		
		boolean pieceTmp[][]=new boolean[h][w];
		
		for (int x = 0; x < w; ++x) {
			for (int y = 0; y < h; ++y) {
				pieceTmp[y][w-1-x] = pieceImpl[x][y];
			}
		}
		
		height=w;
		width=h;
		pieceImpl = new boolean[width][height];
		
		for (int x = 0; x < width; ++x) {
			for (int y = 0; y < height; ++y) {
				pieceImpl[x][y] = pieceTmp[x][y];
			}
		}

		++rotateState;
		
		return true;
	}
	
	public int getRotateState() {
		return rotateState;
	}
	
	private void setSnakeAt(int x, int y) {
		pieceImpl[x][y] = true;
		original[x][y] = true;
	}

	public boolean getSnakeAt(int x, int y) {
		return pieceImpl[x][y];
	}

	
	public static Piece pieces[] = new Piece[8];

	static {
		for (int i = 0; i < 8; ++i) {
			pieces[i] = new Piece(i);
		}

		pieces[0].setSnakeAt(1, 0);
		pieces[0].setSnakeAt(4, 0);
		pieces[0].setSnakeAt(0, 1);
		pieces[0].setSnakeAt(5, 1);
		
		pieces[1].setSnakeAt(1, 2);
		pieces[1].setSnakeAt(4, 2);

		pieces[2].setSnakeAt(1, 2);
		pieces[2].setSnakeAt(1, 0);
		pieces[2].setSnakeAt(4, 0);
		pieces[2].setSnakeAt(0, 1);

		pieces[3].setSnakeAt(1, 0);
		pieces[3].setSnakeAt(5, 1);
		pieces[3].setSnakeAt(4, 2);
		pieces[3].setSnakeAt(1, 2);
		
		pieces[4].setSnakeAt(1, 0);
		pieces[4].setSnakeAt(4, 0);
		pieces[4].setSnakeAt(5, 1);
		
		pieces[5].setSnakeAt(1, 0);
		pieces[5].setSnakeAt(5, 1);
		pieces[5].setSnakeAt(4, 2);
		pieces[5].setSnakeAt(1, 2);
		
		pieces[6].setSnakeAt(0, 1);
		pieces[6].setSnakeAt(1, 2);
		pieces[6].setSnakeAt(4, 2);
		
		pieces[7].setSnakeAt(0, 1);
		pieces[7].setSnakeAt(4, 0);
	}
}
