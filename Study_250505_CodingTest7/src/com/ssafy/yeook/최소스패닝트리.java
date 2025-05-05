package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스패닝트리 {
	static int v, e; // 정점의 수, 주어진 간선의 수.
	static int[] parent; // 루트노드 저장.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		parent = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			parent[i] = i;
		} // 자기자신을 루트로 초기화.

		PriorityQueue<Node> pq = new PriorityQueue<>();

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new Node(a, b, c));

		} // 주어진 간선을 가중치 낮은 순으로 저장.

		int pick = 0; // 선택한 간선의 수.v-1개 선택.
		int sum = 0; // 선택한 가중치 저장.
		while (!pq.isEmpty()) {
			if (pick == v - 1)
				break;
			Node node = pq.poll();
			int a = node.a;
			int b = node.b;
			int c = node.c;

			int rootA = find(a);
			int rootB = find(b);
			if (rootA != rootB) {
				sum += c;
				union(rootA, rootB);
				pick++;
			}
		}
		System.out.println(sum);

	}

	static void union(int rootA, int rootB) {
		if (rootA < rootB)
			parent[rootB] = rootA;
		else
			parent[rootA] = rootB;
	}

	static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	static class Node implements Comparable<Node> {
		int a, b, c; // a=정점1, b=정점2, c = 가중치.

		public Node(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return this.c - o.c;
		}
	}
}
