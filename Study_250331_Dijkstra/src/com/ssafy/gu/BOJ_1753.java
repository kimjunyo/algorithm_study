package com.ssafy.gu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1753 {
	static int V, E;
	static List<Edge>[] graph;
	static final int INF = Integer.MAX_VALUE;
	static int[] dist;
	
	static class Edge {
		int u, v, w;

		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		int K = sc.nextInt();
		
		graph = new ArrayList[V+1];
		for (int i = 1; i < V+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			graph[u].add(new Edge(u, sc.nextInt(), sc.nextInt()));
		}
		
		
		dijkstra(K);
		
		for (int i = 1; i < V+1; i++) {
			if (dist[i] == INF) { 
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
		
	}

	private static void dijkstra(int s) {
		boolean[] visited = new boolean[V+1];
		dist = new int[V+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
		
		pq.addAll(graph[s]);
		visited[s] = true;
		Arrays.fill(dist, INF);
		dist[s] = 0;
		
		int ans = 0;
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (visited[edge.v]) continue;
			visited[edge.v] = true;
			dist[edge.v] = edge.w;
			
			for (Edge e : graph[edge.v]) {
				if (!visited[e.v] && dist[e.v] > dist[e.u] + e.w) {
					pq.add(new Edge(e.u, e.v, dist[e.u] + e.w));
				}
			}
		}
	}
}
