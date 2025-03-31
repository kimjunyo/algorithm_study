package com.ssafy.kyungmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	static List<int[]>[] graph;
	static final int INF = Integer.MAX_VALUE;
	static int[] distances;
	static int[] paths;

	static class Edge {
		private int u;
		private int v;
		private int w;

		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		public int getU() {
			return u;
		}

		public void setU(int u) {
			this.u = u;
		}

		public int getV() {
			return v;
		}

		public void setV(int v) {
			this.v = v;
		}

		public int getW() {
			return w;
		}

		public void setW(int w) {
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [u=" + u + ", v=" + v + ", w=" + w + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 정점 개수 1~20000
		int V = Integer.parseInt(st.nextToken());
		graph = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		distances = new int[V + 1];
		Arrays.fill(distances, INF);
		paths = new int[V + 1];

		// 간선 개수 1~300000
		int E = Integer.parseInt(st.nextToken());
		// 시작 정점 1~K~V
		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			// u->v
			// 같은 from-to 여도 여러개 간선이 있을 수 있음 **
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			// 가중치 1~10
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new int[] { v, w });
		}

		dijkstra(K);

		for (int i = 1; i <= V; i++) {
			System.out.println(distances[i] == INF ? "INF" : distances[i]);
		}
	}

	static void dijkstra(int root) {
		PriorityQueue<int[]> pqo = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

		// 첫 시작
		distances[root] = 0;
		pqo.offer(new int[] { root, 0 });

		while (!pqo.isEmpty()) {
			int[] opt = pqo.poll();

			int u = opt[0];
			int accW = opt[1];

			if (distances[u] < accW) {
//				System.out.println(u + ":" + accW);
				continue;
			}

			for (int[] vw : graph[u]) {
				int v = vw[0];
				int w = vw[1];
				int dist = accW + w;
				// 거리가 더 짧은 경우에만 바꿔치기
//				System.out.println(start + "->" + v + ":" + vw[1]);
				if (distances[v] > dist) {
					distances[v] = dist;
					paths[v] = u;
					pqo.offer(new int[] { v, dist });
				}
			}
		}
	}
}
