package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10868_최솟값 {

	static int[] arr;
	static int[] tree;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
		}

		tree = new int[4 * N];
		Arrays.fill(tree, 2_000_000_000);
		makeTree(1, 1, N);
		int start;
		int end;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			sb.append(getMin(1, 1, N, start, end)).append("\n");
		}
		System.out.println(sb);
	}

	static void makeTree(int idx, int l, int r) {
		if (l == r) {
			tree[idx] = arr[l];
			return;
		}

		int mid = (l + r) / 2;
		makeTree(idx * 2, l, mid);
		makeTree(idx * 2 + 1, mid + 1, r);
		tree[idx] = Math.min(tree[idx * 2], tree[idx * 2 + 1]);
	}

	static int getMin(int idx, int l, int r, int start, int end) {
		if (r < start || l > end) {
			return 2_000_000_000; // 전혀 겹치지 않으면 무시
		}

		if (start <= l && r <= end) {
			return tree[idx]; // 완전히 포함되면 그 노드 값 리턴
		}

		int mid = (l + r) / 2;
		return Math.min(getMin(idx * 2, l, mid, start, end), getMin(idx * 2 + 1, mid + 1, r, start, end));
	}
}
