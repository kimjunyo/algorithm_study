package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2606_바이러스 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		List<Integer>[] coms = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			coms[i] = new ArrayList<>();
		}

		int temp1 = 0;
		int temp2 = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			temp1 = Integer.parseInt(st.nextToken());
			temp2 = Integer.parseInt(st.nextToken());
			coms[temp1].add(temp2);
			coms[temp2].add(temp1);
		}

		Queue<Integer> que = new LinkedList<>();
		boolean[] visit = new boolean[N + 1];
		que.add(1);
		int infected = -1;

		while (!que.isEmpty()) {
			temp1 = que.poll();
			if (!visit[temp1]) {
				visit[temp1] = true;
				infected++;
				for (int i : coms[temp1]) {
					que.add(i);
				}
			}
		}
		System.out.println(infected);

	}
}
