package com.ssafy.gu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1916 {
	static int N, M;
	static List<Edge>[] adj;
	static int[] minCost;
	
	static class Edge {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		adj = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			adj[from].add(new Edge(from, sc.nextInt(), sc.nextInt()));
		}
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		dijkstra(start);
		System.out.println(minCost[end]);
	}

	private static void dijkstra(int start) {
		boolean[] visited = new boolean[N+1];
		minCost = new int[N+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
		
		Arrays.fill(minCost, Integer.MAX_VALUE);
		pq.addAll(adj[start]);
		visited[start] = true;
		minCost[start] = 0;
		
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (visited[edge.to]) continue;
			visited[edge.to] = true;
			minCost[edge.to] = edge.cost;
			
			for (Edge e : adj[edge.to]) {
				if (!visited[e.to] && minCost[e.to] > minCost[e.from] + e.cost) {
					pq.add(new Edge(e.from, e.to, minCost[e.from] + e.cost));
				}
			}
		}
	}
}

