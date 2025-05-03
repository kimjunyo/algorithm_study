package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리와쿼리 {
	static int n, r, q; // 정점의 수, 루트정점, 쿼리 수.
	static List<Integer>[] adjs; // 각정점의 인접정점 저장.
	static int[] depth, count; // 각 정점의 깊이, 각정점의 서브트리에 속한 정점의 수.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		adjs = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adjs[i] = new ArrayList<Integer>();
		} // 인접정점 저장할리스트 생성.

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjs[a].add(b);
			adjs[b].add(a);
		} // 인접정점저장.

		depth = new int[n + 1]; // 각정점의 트리 깊이 저장. (루트 = 0)
		count = new int[n + 1];
		bfsDepth(r);
		recur(r);
		for (int i = 0; i < q; i++) {
			int num = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			System.out.println(count[num]);
		}

	}

	static void recur(int num) {
		if (num != r && adjs[num].size() == 1) {
			count[num] = 1;
			return;
		}
		int sum = 1;
		for (int adj : adjs[num]) {
			if (depth[adj] > depth[num]) {
				recur(adj);
				sum += count[adj];
			}
		}
		count[num] = sum;

	}

	static void bfsDepth(int num) {
		Queue<Integer> needtovisit = new ArrayDeque<>();
		boolean[] visit = new boolean[n + 1];
		needtovisit.add(num);
		visit[num] = true;

		while (!needtovisit.isEmpty()) {
			int length = needtovisit.size();
			for (int i = 0; i < length; i++) {
				int deque = needtovisit.poll();
				int level = depth[deque];
				for (int adj : adjs[deque]) {
					if (!visit[adj]) {
						needtovisit.add(adj);
						visit[adj] = true;
						depth[adj] = level + 1;
					}
				}
			}
		}

	}// 깊이저장
}
