package com.ssafy.yeook;

import java.util.PriorityQueue;

class Solution {
	static int p[];

	public int solution(int n, int[][] costs) {
		// 현재 정점의 루트노드 저장.
		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i; // 처음엔 자기 자신.
		}

		// 주어진 모든 간선을 비용이 낮은 순으로 저장하기.
		PriorityQueue<Edge> edges = new PriorityQueue<>();
		for (int i = 0; i < costs.length; i++) {
			edges.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
		}
		int answer = 0; // 선택한 간선들의 비용의 합.
		int peek = 0; // 선택한 간선의 갯수.
		while (!edges.isEmpty()) {
			Edge e = edges.poll();
			if (find(e.a) != find(e.b)) {
				union(e.a, e.b);
				peek++;
				answer += e.w;
			}
			if (peek == n - 1)
				break;
		}
		return answer;
	}// solution

	// 부모찾기
	int find(int a) {
		if (p[a] != a) {
			p[a] = find(p[a]);
		}
		return p[a];
	}

	// 부모 합치기.
	void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			if (rootA < rootB)
				p[rootB] = rootA;
			else
				p[rootA] = rootB;
		}
	}

	class Edge implements Comparable<Edge> {
		int a, b, w;

		Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
}