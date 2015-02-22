package mpw96;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import mpw96.Tree.PiecePosition;

public class GraphicSolutionPresenter extends JFrame implements
		SolutionPresenter {

	private static final long serialVersionUID = -3921895786204455004L;

	public class BoardPanel extends JPanel {

		private static final long serialVersionUID = 1869370466378521800L;
		private Board board;
		
		public BoardPanel(Board b) {
			board=b;
		}

		private Color getColorForPiece(int i) {
			switch (i) {
			case 0: return Color.WHITE;
			case 1: return Color.BLACK;
			case 2: return Color.BLUE;
			case 3: return Color.CYAN;
			case 4: return Color.GREEN;
			case 5: return Color.MAGENTA;
			case 6: return Color.ORANGE;
			case 7: return Color.PINK;
			case 8: return Color.RED;
			case 9: return Color.YELLOW;
			default: return Color.WHITE;
			}
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			for(int x=0; x<4; ++x) {
				for(int y=0; y<12; ++y) {
					g.setColor(getColorForPiece(board.getCell(3-x, y)));
					g.fillRect(y*21, x*21, 20, 20);
				}
			}
		}
	}

	private JPanel drawPanel;

	public GraphicSolutionPresenter(Board b) {
		super("Das fiese Puzzle");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 270;
		int frameHeight = 200;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		Container cp = getContentPane();
		cp.setLayout(null);

		drawPanel = new BoardPanel(b);
		drawPanel.setBounds(0, 0, 270, 200);
		drawPanel.setBackground(Color.WHITE);
		cp.add(drawPanel);

		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		Board b = new Board();
		b.placePieceAt(0, 0, Piece.pieces[3]);
		new GraphicSolutionPresenter(b);
		System.out.println("dahinter");
	}

	public void printPosition(int pieceIndex, int x, int y) {
	}

	public void printLoopInfo(int placingPiece) {
		drawPanel.repaint();
//		try {
//			Thread.sleep(30);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
	}

	public void printSolution(PiecePosition[] pp) {
		drawPanel.repaint();
	}

	public void printNoSolution() {
	}

}
