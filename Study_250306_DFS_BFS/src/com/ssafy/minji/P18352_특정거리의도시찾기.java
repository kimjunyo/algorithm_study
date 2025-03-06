package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P18352_특정거리의도시찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		List<Integer>[] list = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}

		List<Integer> ansList = new ArrayList<>();
		int[] distance = new int[N + 1];
		Arrays.fill(distance, -1);

		Queue<Integer> que = new LinkedList<>();
		que.add(X);
		distance[X] = 0;
		while (!que.isEmpty()) {
			int curr = que.poll();
			for (int i : list[curr]) {
				if (distance[i] == -1) {
					distance[i] = distance[curr] + 1;
					que.add(i);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (i != X && distance[i] == K) {
				ansList.add(i);
			}
		}

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
}
