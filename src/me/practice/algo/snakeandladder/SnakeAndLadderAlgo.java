package me.practice.algo.snakeandladder;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadderAlgo {
	public int countDistance(int[] board) {
		Queue<Entry> q = new LinkedList<>();
		final int boardSize = board.length;
		int visited[] = new int[boardSize];
		visited[0] = 1;
		Entry e = new Entry(0, 0);
		q.add(e);
		while (!q.isEmpty()) {
			e = q.remove();
			if (e.vertex == boardSize - 1)
				break;

			for (int j = e.vertex + 1; j <= (e.vertex + 6) && j < boardSize; ++j) {
				if (visited[j] != 1) {
					System.out.println(String.format("Visisting vertex %d.", j));
					Entry entry = null;
					if (board[j] == -1) {
						entry = new Entry(j, e.distance + 1);
					} else {
						entry = new Entry(board[j], e.distance + 1);
					}
					q.add(entry);
					visited[j] = 1;
				} else {
					System.out.println(String.format("Vertex %d is already visited.", j));
				}
			}
		}
		return e.distance;
	}

	public static void main(String[] args) {
		SnakeAndLadderAlgo algo = new SnakeAndLadderAlgo();
		final int N = 30;
		int[] board = new int[N];

		for (int i = 0; i < N; i++)
			board[i] = -1;

		// Ladders
		board[2] = 21;
		board[4] = 7;
		board[10] = 25;
		board[19] = 28;

		// Snakes
		board[26] = 0;
		board[20] = 8;
		board[16] = 3;
		board[18] = 6;

		System.out.println("Min Dice throws required is " + algo.countDistance(board));
	}
}

class Entry {
	int vertex;
	int distance;

	Entry(int vertex, int distance) {
		this.vertex = vertex;
		this.distance = distance;
	}
}