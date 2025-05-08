package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1005_ACMCraft {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1 ; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] time = new int[N + 1];
			List<Integer>[] rules = new List[N + 1];
			for(int i = 0 ; i < N + 1 ; i++) {
				rules[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i <= N ; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			int x, y;
			for(int i = 0 ; i < K ; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				rules[y].add(x);
			}
			
			int W = Integer.parseInt(br.readLine().trim());
			int[] maxs = new int[N];
			Queue<int[]> que = new LinkedList<>();
			que.add(new int[] {W, 0});
			
			int[] temp;
			int curr, depth;
			while(!que.isEmpty()) {
				temp = que.poll();
				curr = temp[0];
				depth = temp[1];
				for(int t : rules[curr]) {
					if(time[t] > maxs[depth]) {
						maxs[depth] = time[t];
					}
					que.add(new int[] {t, depth + 1});
				}
			}
			
			long ans = time[W];
			for(int i = 0 ; i < N ; i++) {
				if(maxs[i] == 0) {
					break;
				}
				ans += maxs[i];
			}
			
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
