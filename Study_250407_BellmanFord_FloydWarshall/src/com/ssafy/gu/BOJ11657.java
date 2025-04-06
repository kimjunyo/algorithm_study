package com.ssafy.gu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ11657 {
	static class Edge {
		int s, e, time;

		public Edge(int s, int e, int time) {
			this.s = s;
			this.e = e;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		List<Edge>[] adj = new ArrayList[N+1];
		long[] dist = new long[N+1];
		
		for (int i = 1; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			adj[s].add(new Edge(s, sc.nextInt(), sc.nextInt()));
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		
		for (int j = 0; j < N-1; j++) {
			boolean flag = false;
			for (int i = 1; i < N+1; i++) {
				for (Edge edge : adj[i]) {
					if (dist[edge.s] != Integer.MAX_VALUE && dist[edge.s]+edge.time < dist[edge.e]) {
						dist[edge.e] = dist[edge.s]+edge.time;
						flag = true;
					}
				}
			}
			if (!flag) break;
		}
		
		boolean cycleCheck = false;
		
		outer:
		for (int i = 1; i < N+1; i++) {
			for (Edge edge : adj[i]) {
				if (dist[edge.s] != Integer.MAX_VALUE && dist[edge.s]+edge.time < dist[edge.e]) {
					cycleCheck = true;
					break outer;
				}
			}
		}
		
		if (cycleCheck) {
			System.out.println(-1);
		} else {
			for (int i = 2; i < N+1; i++) {
				if (dist[i] == Integer.MAX_VALUE) {
					System.out.println(-1);
				} else {
					System.out.println(dist[i]);
				}
			}
		}
	}
}
