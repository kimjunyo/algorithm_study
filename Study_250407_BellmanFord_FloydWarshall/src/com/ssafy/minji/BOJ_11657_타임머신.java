package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11657_타임머신 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<int[]> list = new ArrayList<>();

		long[] dist = new long[N + 1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[1] = 0;

		int from;
		int to;
		int cost;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			list.add(new int[] { from, to, cost });
		}

		for (int i = 0; i < N - 1; i++) {
			for (int[] cur : list) {
				from = cur[0];
				to = cur[1];
				cost = cur[2];
				if (dist[from] != Long.MAX_VALUE && dist[to] > dist[from] + cost) {
					dist[to] = dist[from] + cost;
				}
			}
		}

		boolean cycleFlag = false;
		for (int[] cur : list) {
			from = cur[0];
			to = cur[1];
			cost = cur[2];
			if (dist[from] != Long.MAX_VALUE && dist[to] > dist[from] + cost) {
				cycleFlag = true;
				System.out.println(-1);
				return;
			}
		}
		
		for(int i = 2 ; i < N + 1 ; i++) {
			if(dist[i] == Long.MAX_VALUE) {
				System.out.println(-1);
			}else {
				System.out.println(dist[i]);
			}
		}
		
	}
}
