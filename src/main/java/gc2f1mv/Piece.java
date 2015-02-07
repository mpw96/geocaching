package gc2f1mv;

public class Piece {

	final private int index;
	private int original[][] = null;
	private int owidth = 0;
	private int oheight = 0;
	
	private int pieceImpl[][] = new int[5][5];
	private int pieceTmp[][] = new int[5][5];
	private int width = 0;
	private int height = 0;
	private int rotateState=0;
	
	private Piece(int _index) {
		index=_index;
		init(pieceImpl);
	}

	private void init(int[][] piece) {
		for (int x = 0; x < 5; ++x) {
			for (int y = 0; y < 5; ++y) {
				piece[x][y] = 0;
			}
		}
	}

	public int getValueAt(int x, int y) {
		return pieceImpl[x][y];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void print() {
		for (int x = 4; x >= 0; --x) {
			for (int y = 0; y < 5; ++y) {
				System.out.print(pieceImpl[x][y]);
			}
			System.out.println();
		}
		System.out.println("width: " + getWidth() + ", height: " + getHeight());
	}

	
	public void resetRotateState() {
		if(0!=rotateState) {
			for (int x = 0; x < 5; ++x) {
				for (int y = 0; y < 5; ++y) {
					pieceImpl[x][y] = original[x][y];
				}
			}
			width=owidth;
			height=oheight;
			rotateState=0;
		}
		
	}
	
	public boolean rotate() {
		
		if(3==rotateState) {
			return false;
		}
		
		if(null==original) {
			original=new int[5][5];
			for (int x = 0; x < 5; ++x) {
				for (int y = 0; y < 5; ++y) {
					original[x][y] = pieceImpl[x][y];
				}
			}
			owidth=width;
			oheight=height;
		}
		
		init(pieceTmp);
		int h = getHeight();
		int w = getWidth();
		
		for (int x = 0; x < h; ++x) {
			for (int y = 0; y < w; ++y) {
				pieceTmp[y][h-1-x] = pieceImpl[x][y];
			}
		}
		
		
		for (int x = 0; x < 5; ++x) {
			for (int y = 0; y < 5; ++y) {
				pieceImpl[x][y] = pieceTmp[x][y];
			}
		}

		height=w;
		width=h;
		++rotateState;
		
		return true;
	}
	
	public int getRotateState() {
		return rotateState;
	}
	
	private void setPartAt(int x, int y) {
		pieceImpl[x][y] = index+1;
		if (x >= height) {
			height = x + 1;
		}
		if (y >= width) {
			width = y + 1;
		}
	}

	static public Piece pieces[] = new Piece[9];

	static {
		for (int i = 0; i < 9; ++i) {
			pieces[i] = new Piece(i);
		}

		pieces[0].setPartAt(3, 0);
		pieces[0].setPartAt(3, 1);
		pieces[0].setPartAt(3, 2);
		pieces[0].setPartAt(3, 3);
		pieces[0].setPartAt(3, 4);
		pieces[0].setPartAt(0, 2);
		pieces[0].setPartAt(1, 2);
		pieces[0].setPartAt(2, 2);

		pieces[1].setPartAt(0, 0);
		pieces[1].setPartAt(0, 1);
		pieces[1].setPartAt(0, 2);
		pieces[1].setPartAt(0, 3);
		pieces[1].setPartAt(0, 4);
		pieces[1].setPartAt(1, 3);
		pieces[1].setPartAt(2, 3);

		pieces[2].setPartAt(0, 0);
		pieces[2].setPartAt(0, 1);
		pieces[2].setPartAt(0, 2);
		pieces[2].setPartAt(0, 3);
		pieces[2].setPartAt(1, 3);

		pieces[3].setPartAt(0, 1);
		pieces[3].setPartAt(1, 0);
		pieces[3].setPartAt(1, 1);
		pieces[3].setPartAt(2, 0);
		pieces[3].setPartAt(2, 1);

		pieces[4].setPartAt(0, 0);
		pieces[4].setPartAt(1, 0);
		pieces[4].setPartAt(2, 0);
		pieces[4].setPartAt(2, 1);
		pieces[4].setPartAt(2, 2);

		pieces[5].setPartAt(0, 0);
		pieces[5].setPartAt(0, 1);
		pieces[5].setPartAt(0, 2);
		pieces[5].setPartAt(1, 1);
		pieces[5].setPartAt(2, 1);

		pieces[6].setPartAt(0, 0);
		pieces[6].setPartAt(0, 1);
		pieces[6].setPartAt(0, 2);
		pieces[6].setPartAt(1, 2);

		pieces[7].setPartAt(0, 0);
		pieces[7].setPartAt(0, 1);
		pieces[7].setPartAt(1, 0);
		pieces[7].setPartAt(1, 1);


		pieces[8].setPartAt(0, 0);
		pieces[8].setPartAt(1, 0);
		pieces[8].setPartAt(1, 1);
		pieces[8].setPartAt(2, 1);
	}

	public static void main(String[] args) {
		
		int piecei=1;
		
		do {
			System.out.println(pieces[piecei].getRotateState());
			pieces[piecei].print();
			System.out.println();
		} while(pieces[piecei].rotate());
		
		pieces[piecei].resetRotateState();
		System.out.println(pieces[piecei].getRotateState());
		pieces[piecei].print();
	}

}
