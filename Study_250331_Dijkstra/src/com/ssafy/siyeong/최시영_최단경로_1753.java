package com.ssafy.siyeong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 최시영_최단경로_1753 {
	static class Edge {
		int to, cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	static int V, E, K;
	static List<Edge>[] adj;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		adj = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[u].add(new Edge(v, w));
		}
		dijkstra(K);
		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}

	private static void dijkstra(int start) {
		boolean[] visited = new boolean[V + 1];

		for (int i = 1; i < V; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for (int j = 1; j <= V; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}
			if (idx == -1) break;
			visited[idx] = true;
			
			for (Edge e : adj[idx]) {
				if (!visited[e.to] && dist[e.to] > dist[idx] + e.cost) {
					dist[e.to] = dist[idx] + e.cost;
				}
			}
		}

	}
}
