package com.ssafy.gu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
	int x;
	int y;
	int count;
	
	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ2178 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] maze = new int[N][M];
		Position[][] position = new Position[N][M];
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < M; j++) {
				maze[i][j] = line.charAt(j)-'0';
				position[i][j] = new Position(i, j);
			}
		}
		
		Queue<Position> q = new LinkedList<>();
		q.add(position[0][0]);
		position[0][0].count = 1;
		visited[0][0] = true;
		
		while (!q.isEmpty()) {
			Position p = q.poll();
			int i = p.x;
			int j = p.y;
			
			if (i == N-1 && j == M-1) {
				System.out.println(p.count);
				return;
			}
			
			if (i-1 > -1 && maze[i-1][j] == 1 && !visited[i-1][j]) {
				q.add(position[i-1][j]);
				position[i-1][j].count = p.count+1;
				visited[i-1][j] = true;
			}
			if (j-1 > -1 && maze[i][j-1] == 1 && !visited[i][j-1]) {
				q.add(position[i][j-1]);
				position[i][j-1].count = p.count+1;
				visited[i][j-1] = true;
			}
			if (i+1 < N && maze[i+1][j] == 1 && !visited[i+1][j]) {
				q.add(position[i+1][j]);
				position[i+1][j].count = p.count+1;
				visited[i+1][j] = true;
			}
			if (j+1 < M && maze[i][j+1] == 1 && !visited[i][j+1]) {
				q.add(position[i][j+1]);
				position[i][j+1].count = p.count+1;
				visited[i][j+1] = true;
			}
		}
	}
}
