package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P1325_효율적인해킹 {
	static List<Integer>[] list;
	static int[] cnt;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		int temp1, temp2;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			temp1 = Integer.parseInt(st.nextToken());
			temp2 = Integer.parseInt(st.nextToken());
			list[temp1].add(temp2);
		}

		cnt = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			BFS(i);
		}
		int max = 0;
		for(int i = 1 ; i <= N ; i++) {
			if(max < cnt[i]) {
				max = cnt[i];
			}
		}
		for(int i = 1 ; i <= N ; i++) {
			if(max == cnt[i]) {
				System.out.print(i + " ");
			}
		}
	}

	static void BFS(int idx) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(idx);
		visited[idx] = true;

		int temp = 0;
		while (!que.isEmpty()) {
			temp = que.poll();
			for (int i : list[temp]) {
				if (visited[i] == false) {
					visited[i] = true;
					cnt[i]++;
					que.add(i);
				}
			}
		}
	}
}
