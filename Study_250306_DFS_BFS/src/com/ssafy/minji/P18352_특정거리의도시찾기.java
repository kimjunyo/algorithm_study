package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P18352_특정거리의도시찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static int K;
	static int X;
	static List<Integer>[] list;
	static List<Integer> ansList;
	static boolean[] visited;
	static Queue<Integer> que;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		list = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}

		ansList = new ArrayList<>();
		visited = new boolean[N + 1];
		visited[X] = true;
		que = new LinkedList<>();
		trip(X, 0);

		if (ansList.isEmpty()) {
			System.out.println(-1);
		} else {
			ansList.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
			});
			for (int i : ansList) {
				System.out.println(i);
			}
		}
	}

	static void trip(int idx, int cnt) {
//		if (visited[idx]) {
//			return;
//		} else {
//			visited[idx] = true;
//		}

		if (cnt == K) {
			ansList.add(idx);
			return;
		}

		for (int i : list[idx]) {
			if (!visited[i]) {
				visited[i] = true;
				que.add(i);
			}
		}

		while (!que.isEmpty()) {
			trip(que.poll(), cnt + 1);
		}

	}

}
