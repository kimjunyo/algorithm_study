package com.ssafy.siyeong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이분그래프_1707 {
	static List<Integer>[] list;
	static int[] colors;
	final static int RED = 1;
	final static int BLUE = -1;
	static boolean result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			colors = new int[V + 1];
			list = new ArrayList[V + 1];
			result = true;
			for (int i = 1; i <= V; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			for (int i = 1; i <= V; i++) {
				if (colors[i] == 0 && result) {
					bfs(i);
				}
			}
			System.out.println(result ? "YES" : "NO");
		}
	}
	
	private static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		colors[n] = RED;
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int next : list[x]) {
				if (colors[next] == 0) {
					
					q.add(next);
					colors[next] = -colors[x];
				}
				else if (colors[x] == colors[next]) {
					result = false;
					return;
				}
			}
		}
			
	}
}
