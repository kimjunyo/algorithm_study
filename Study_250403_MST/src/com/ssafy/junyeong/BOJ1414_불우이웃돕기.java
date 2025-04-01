package com.ssafy.junyeong;

import java.util.*;
import java.io.*;

class BOJ1414_불우이웃돕기 {

	static class Edge implements Comparable<Edge> {
		int first, second, value;

		Edge(int first, int second, int value) {
			this.first = first;
			this.second = second;
			this.value = value;
		}

		@Override
		public int compareTo(Edge o) {
			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			char one = br.readLine().toCharArray()[0];
			int sum = 0;
			if(one != '0') 
				sum = (one >= 'a') ? one - 'a' + 1 : one - 'A' + 27;

			bw.write(sum + "");
			bw.flush();
			return;
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int[] parent = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		int totalSum = 0;
		boolean isConnected = false;
		for (int i = 1; i <= N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (input[j] == '0')
					continue;

				int value = (input[j] >= 'a') ? input[j] - 'a' + 1 : input[j] - 'A' + 27;

				if (i != j + 1) {
					pq.offer(new Edge(i, j + 1, value));

				}
				totalSum += value;
			}
		}

		int pick = 0;
		int res = 0;
		while (!pq.isEmpty()) {
			Edge e = pq.poll();

			if (find(e.first, parent) != find(e.second, parent)) {
				union(e.first, e.second, parent);
				pick++;
				res += e.value;
			}

			if (pick == N - 1) {
				isConnected = true;
				break;
			}
		}

		if (!isConnected) {
			bw.write(-1 + "");
			bw.flush();
			return;
		}

		bw.write((totalSum - res) + "");
		bw.flush();
	}

	private static void union(int x, int y, int[] parent) {
		x = find(x, parent);
		y = find(y, parent);

		if (x > y) {
			parent[x] = y;
		} else {
			parent[y] = x;
		}
	}

	private static int find(int x, int[] parent) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x], parent);
	}
}