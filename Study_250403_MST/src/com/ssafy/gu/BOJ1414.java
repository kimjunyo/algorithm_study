package com.ssafy.gu;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1414 {
	static class Edge {
		int to, len;

		public Edge(int to, int len) {
			this.to = to;
			this.len = len;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] coms = new int[N][N];
		
		int all = 0;
		for (int i = 0; i < N; i++) {
			String row = sc.next();
			for (int j = 0; j < N; j++) {
				char tg = row.charAt(j);
				if (tg == '0') continue;
				if (tg >= 'a' && tg <= 'z') coms[i][j] = tg - 'a' + 1;
				if (tg >= 'A' && tg <= 'Z') coms[i][j] = tg - 'A' + 27;
				all += coms[i][j];
			}
		}
		
		boolean[] visited = new boolean[N];
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.len - b.len);
		
		pq.add(new Edge(0, 0));
		
		int pick = 0;
		int minLen = 0;
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (visited[e.to]) continue;
			visited[e.to] = true;
			pick++;
			minLen += e.len;
			
			if (pick == N) break;
			
			for (int i = 0; i < N; i++) {
				if (visited[i]) continue;
				if (coms[e.to][i] > 0) pq.add(new Edge(i, coms[e.to][i]));
				if (coms[i][e.to] > 0) pq.add(new Edge(i, coms[i][e.to]));
			}
		}
		
		System.out.println(pick == N ? all-minLen : -1);
	}
}
