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

		private Color getColorForPiece(Cell cell) {
			switch (cell.getOccupyingPiece()) {
			case 0:
				return Color.RED;
			case 1:
				return Color.BLACK;
			case 2:
				return Color.BLUE;
			case 3:
				return Color.CYAN;
			case 4:
				return Color.GREEN;
			case 5:
				return Color.YELLOW;
			case 6:
				return Color.ORANGE;
			case 7:
				return Color.PINK;
			default:
				return Color.WHITE;
			}
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			for(int x=0; x<12; ++x) {
				for(int y=0; y<12; ++y) {
					g.setColor(getColorForPiece(board.getCell(x, 11-y)));
					g.fillRect(x*21, y*21, 20, 20);
					if(board.getCell(x, 11-y).isSnake()) {
						g.setColor(Color.DARK_GRAY);
						g.fillOval(x*21+5, y*21+5, 10, 10);
					}
				}
			}
		}
	}

	private JPanel drawPanel;

	public GraphicSolutionPresenter(Board b) {
		super("Der SchlängelSchlingel");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 300;
		int frameHeight = 300;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		Container cp = getContentPane();
		cp.setLayout(null);

		drawPanel = new BoardPanel(b);
		drawPanel.setBounds(0, 0, 300, 300);
		drawPanel.setBackground(Color.WHITE);
		cp.add(drawPanel);

		setResizable(false);
		setVisible(true);
	}
	public void printPosition(int pieceIndex, int x, int y) {
	}

	public void printLoopInfo(int placingPiece) {
		drawPanel.repaint();
		try {
			Thread.sleep(5);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void printSolution(PiecePosition[] pp) {
		drawPanel.repaint();
	}

	public void printNoSolution() {
	}

}
