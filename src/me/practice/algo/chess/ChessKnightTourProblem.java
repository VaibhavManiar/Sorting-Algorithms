package me.practice.algo.chess;

public class ChessKnightTourProblem {
	private final int[][] chessBoard;
	private final int chessBoardSize = 8;
	private final int[] xMoves = { 2, 1, -1, -2, - 2, -1, 1, 2 };
	private final int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public ChessKnightTourProblem() {
		chessBoard = new int[chessBoardSize][chessBoardSize];
		init();
	}

	private void init() {
		for (int i = 0; i < chessBoardSize; ++i)
			for (int j = 0; j < chessBoardSize; ++j)
				chessBoard[i][j] = Integer.MIN_VALUE;
	}

	public void solve() {
		int stepCount = 0;
		int x = 0;
		int y = 0;
		chessBoard[x][y] = stepCount;
		if (!solveProblem(stepCount + 1, x, y)) {
			System.out.println("Not valid.");
			return;
		}

		printChessBoard();
	}

	private boolean solveProblem(int stepCount, int x, int y) {
		if (stepCount == chessBoardSize * chessBoardSize)
			return true;

		for (int i = 0; i < chessBoardSize; ++i) {
			int nextX = x + xMoves[i];
			int nextY = y + yMoves[i];

			if (this.isValidMove(nextX, nextY)) {
				this.chessBoard[nextX][nextY] = stepCount;
				if (this.solveProblem(stepCount + 1, nextX, nextY))
					return true;
				this.chessBoard[nextX][nextY] = Integer.MIN_VALUE;
			}
		}
		return false;
	}

	private boolean isValidMove(int x, int y) {
		if (x < 0 || x >= chessBoardSize)
			return false;
		if (y < 0 || y >= chessBoardSize)
			return false;
		if (chessBoard[x][y] != Integer.MIN_VALUE)
			return false;

		return true;
	}

	private void printChessBoard() {
		for (int i = 0; i < chessBoardSize; i++) {
			for (int j = 0; j < chessBoardSize; j++)
				System.out.print(chessBoard[i][j] + "  ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ChessKnightTourProblem problem = new ChessKnightTourProblem();
		problem.solve();
	}
}
