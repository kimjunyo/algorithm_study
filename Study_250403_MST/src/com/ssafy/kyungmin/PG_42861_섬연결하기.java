package com.ssafy.kyungmin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PG_42861_섬연결하기 {
	public static void main(String[] args) {
		Prim sol = new Prim();

		int n = 4;
		int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };

		int result = sol.solution(n, costs);
		System.out.println(result);
	}
}

class Kruskal {
	static int[] parent;

	public int solution(int n, int[][] costs) {
		int answer = 0;

		parent = new int[n + 1];
		for (int i = 1; i < n; i++) {
			parent[i] = i;
		}

		// 간선에 따라 정렬
		Arrays.sort(costs, (a, b) -> a[2] - b[2]);

		for (int i = 0; i < costs.length; i++) {
			int a = costs[i][0];
			int b = costs[i][1];
			int cost = costs[i][2];

			// 사이클 검사
			if (find(a) != find(b)) {
				union(a, b);
				answer += cost;
			}
		}

		return answer;
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB)
			return;

		parent[rootA] = rootB;
	}

	static int find(int a) {
		if (parent[a] != a) {
			return parent[a] = find(parent[a]);
		}
		return a;
	}
}

class Prim {
	class Vertex {
		int other;
		int cost;

		public Vertex(int other, int cost) {
			this.other = other;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Vertex [other=" + other + ", cost=" + cost + "]";
		}

	}

	static boolean[] visited;

	public int solution(int n, int[][] costs) {
		int answer = 0;

		PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.cost));

		visited = new boolean[n];

		int start = 0;
		pq.offer(new Vertex(start, 0));

		while (!pq.isEmpty()) {
			Vertex v = pq.poll();

			if (visited[v.other])
				continue;

			visited[v.other] = true;
			answer += v.cost;

			for (int i = 0; i < costs.length; i++) {
				int a = costs[i][0];
				int b = costs[i][1];
				int cost = costs[i][2];

				// 무방향!! 이므로, 간선 양으로 연결된 v 확인해야함.
				if (a == v.other && !visited[b]) {
					pq.offer(new Vertex(b, cost));
				}

				if (b == v.other && !visited[a]) {
					pq.offer(new Vertex(a, cost));
				}
			}
		}

		return answer;
	}
}
