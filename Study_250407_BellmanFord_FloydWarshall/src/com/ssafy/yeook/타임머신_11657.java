package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 타임머신_11657 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 1번부터 n번까지
		int m = Integer.parseInt(st.nextToken());
		Edge[] edges = new Edge[m]; // 간선 저장.
		long[] shortestPath = new long[n + 1];
		Arrays.fill(shortestPath, Long.MAX_VALUE);
		shortestPath[1] = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(a, b, w);
		}

		// 최단거리 데이블 완성.
		for (int i = 0; i < n - 1; i++) {
			for (Edge e : edges) {
				if (shortestPath[e.a] != Long.MAX_VALUE && shortestPath[e.b] > shortestPath[e.a] + e.w) {
					shortestPath[e.b] = shortestPath[e.a] + e.w;
				}
			}

		}
		// 음의 사이클 여부 확인.
		boolean isOk = true; // 음의 사이클 없음.
		for (Edge e : edges) {
			if (shortestPath[e.a] != Long.MAX_VALUE && shortestPath[e.b] > shortestPath[e.a] + e.w) {
				isOk = false;
				break;
			}
		}

		// 음의 가중치 없으면?
		if (isOk) {
			for (int i = 2; i <= n; i++) {
				if (shortestPath[i] == Long.MAX_VALUE) {
					System.out.println(-1);
				} else
					System.out.println(shortestPath[i]);
			}

		} else {
			System.out.println(-1);
		}

	}// main

	static class Edge {
		int a, b, w;

		public Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

	}
}
