package gc2f1mv;

public class BruteForce {
	static private boolean stop = false;

	public static void main(String[] args) {

		class Cruncher extends Thread {
			private final int y0min;
			private final int y0ubound;

			public Cruncher(int _y0min, int _y0ubound) {
				y0min = _y0min;
				y0ubound = _y0ubound;
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Board board = new Board();
				int x[] = new int[9];
				int y[] = new int[9];
				for (int t = 0; t < 9; ++t) {
					x[t] = 0;
					y[t] = 0;
				}

				// int pc=0;

				for (x[0] = 0; x[0] <= 4 - Piece.pieces[0].getHeight(); ++x[0]) {
					// for (y[0]=0; y[0]<=12-Piece.pieces[0].getWidth(); ++y[0]) {
					for (y[0] = y0min; y[0] < y0ubound; ++y[0]) {
						for (x[1] = 0; x[1] <= 4 - Piece.pieces[1].getHeight(); ++x[1]) {
							for (y[1] = 0; y[1] <= 12 - Piece.pieces[1]
									.getWidth(); ++y[1]) {
								for (x[2] = 0; x[2] <= 4 - Piece.pieces[2]
										.getHeight(); ++x[2]) {
									for (y[2] = 0; y[2] <= 12 - Piece.pieces[2]
											.getWidth(); ++y[2]) {
										for (x[3] = 0; x[3] <= 4 - Piece.pieces[3]
												.getHeight(); ++x[3]) {
											for (y[3] = 0; y[3] <= 12 - Piece.pieces[3]
													.getWidth(); ++y[3]) {
												for (x[4] = 0; x[4] <= 4 - Piece.pieces[4]
														.getHeight(); ++x[4]) {
													for (y[4] = 0; y[4] <= 12 - Piece.pieces[4]
															.getWidth(); ++y[4]) {
														for (x[5] = 0; x[5] <= 4 - Piece.pieces[5]
																.getHeight(); ++x[5]) {
															for (y[5] = 0; y[5] <= 12 - Piece.pieces[5]
																	.getWidth(); ++y[5]) {
																for (x[6] = 0; x[6] <= 4 - Piece.pieces[6]
																		.getHeight(); ++x[6]) {
																	for (y[6] = 0; y[6] <= 12 - Piece.pieces[6]
																			.getWidth(); ++y[6]) {
																		for (x[7] = 0; x[7] <= 4 - Piece.pieces[7]
																				.getHeight(); ++x[7]) {
																			for (y[7] = 0; y[7] <= 12 - Piece.pieces[7]
																					.getWidth(); ++y[7]) {
																				for (x[8] = 0; x[8] <= 4 - Piece.pieces[8]
																						.getHeight(); ++x[8]) {
																					for (y[8] = 0; y[8] <= 12 - Piece.pieces[8]
																							.getWidth(); ++y[8]) {

																						if (stop) {
																							return;
																						}

																						board.init();
																						if (board
																								.placePieceAt(
																										x[0],
																										y[0],
																										Piece.pieces[0])
																								&& board.placePieceAt(
																										x[1],
																										y[1],
																										Piece.pieces[1])
																								&& board.placePieceAt(
																										x[2],
																										y[2],
																										Piece.pieces[2])
																								&& board.placePieceAt(
																										x[3],
																										y[3],
																										Piece.pieces[3])
																								&& board.placePieceAt(
																										x[4],
																										y[4],
																										Piece.pieces[4])
																								&& board.placePieceAt(
																										x[5],
																										y[5],
																										Piece.pieces[5])
																								&& board.placePieceAt(
																										x[6],
																										y[6],
																										Piece.pieces[6])
																								&& board.placePieceAt(
																										x[7],
																										y[7],
																										Piece.pieces[7])
																								&& board.placePieceAt(
																										x[8],
																										y[8],
																										Piece.pieces[8])
																								&& board.hasGoodPlacement()) {
																							board.print();
																							System.out
																									.println();
																							for (int p = 0; p < 9; ++p) {
																								Piece.pieces[p]
																										.print();
																								System.out
																										.println("at "
																												+ x[p]
																												+ ", "
																												+ y[p]);
																								System.out
																										.println("=======================================");
																							}

																							stop = true;
																							return;
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		;

		Cruncher c0 = new Cruncher(0, 1);
		Cruncher c1 = new Cruncher(1, 2);
		Cruncher c2 = new Cruncher(2, 3);
		Cruncher c3 = new Cruncher(3, 4);
		Cruncher c4 = new Cruncher(4, 5);
		Cruncher c5 = new Cruncher(5, 6);
		Cruncher c6 = new Cruncher(6, 7);
		Cruncher c7 = new Cruncher(7, 8);

		c0.start();
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		c6.start();
		c7.start();
		try {
			c0.join();
			c1.join();
			c2.join();
			c3.join();
			c4.join();
			c5.join();
			c6.join();
			c7.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
