package com.ssafy.kyungmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자 {
	private static int[] city;
	private static int[] rank;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// ~200 도시의 수
		int N = Integer.parseInt(br.readLine());
		// 여행 계획에 속한 도시의 수
		// ~1000
		int M = Integer.parseInt(br.readLine());
		// 길이 있다면 집합
		// 길이 없다면 집합아님

		city = new int[N + 1];
		rank = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			city[i] = i;
		}

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					union(i, j);
				}
			}
		}

		int[] check = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}

		boolean possible = true;
		for (int i = 0; i < M - 1; i++) {
			if (find(check[i]) != find(check[i + 1])) {
				possible = false;
			}
		}
		if (possible) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX == rootY)
			return;

		if (rank[rootX] > rank[rootY]) {
			city[rootY] = rootX;
		} else if (rank[rootX] < rank[rootY]) {
			city[rootX] = rootY;
		} else {
			city[rootX] = rootY;
			rank[rootY]++;
		}
	}

	private static int find(int x) {
		if (city[x] != x) {
			return city[x] = find(city[x]);
		}
		return x;
	}
}
