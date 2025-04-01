package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 불우이웃돕기_1414 {
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] adjs = new int[n][n];
		p = new int[n]; // 부모 저장.
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}
		int total = 0;
		PriorityQueue<Edge> edges = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				int num = str.charAt(j);
				if (num >= 'A' && num <= 'Z') { // 대문자이면
					num -= 38;
				} else if (num >= 'a' && num <= 'z') {
					num -= 96;
				} else
					num = 0;

				if (num != 0) {
					adjs[i][j] = num;
					total += num;
					edges.add(new Edge(i, j, num));
				}

			}
		} // 주어진 입력 저장.

		boolean[] visit = new boolean[n];

		int peek = 0;
		int sum = 0;
		int length = edges.size();
		for (int i = 0; i < length; i++) {
			Edge e = edges.poll();
			int a = e.a;
			int b = e.b;
			int w = e.w;

			if (w != 0 && find(a) != find(b)) {
				union(a, b);
				total -= w;
				peek++;
			}
			if (peek == n - 1) {
				System.out.println(total);
				return;
			}

		}

		// 1개의 컴퓨터만 있더라도 -1이아닌 값 출력하도록 해야함.
		if (peek == n - 1) {
			System.out.println(total);
			return;
		}
		if (peek != n - 1) {
			System.out.println(-1);

		}

	}// main

	static int find(int a) {
		if (p[a] == a)
			return a;
		return p[a] = find(p[a]);

	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			if (rootA < rootB)
				p[rootB] = rootA;
			else
				p[rootA] = rootB;
		}
	}

	static class Edge implements Comparable<Edge> {
		int a, b, w;

		public Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}

	}
}
