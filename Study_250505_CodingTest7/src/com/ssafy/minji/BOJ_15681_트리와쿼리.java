package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15681_트리와쿼리 {
	static List<Integer>[] tree;
	static int[] subTreeCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		tree = new List[N + 1];
		subTreeCnt = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			tree[i] = new ArrayList<>();
		}

		int n1, n2;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			tree[n1].add(n2);
			tree[n2].add(n1);
		}
		
		makeDir(R);

		int node;
		for (int i = 0; i < Q; i++) {
			node = Integer.parseInt(br.readLine().trim());
			System.out.println(subTreeCnt[node]);
		}

	}

	static int makeDir(int parent) {
		int count = 1;
		for (int i : tree[parent]) {
			tree[i].remove(Integer.valueOf(parent));
			count += makeDir(i);
		}
		return subTreeCnt[parent] = count;
	}
}
