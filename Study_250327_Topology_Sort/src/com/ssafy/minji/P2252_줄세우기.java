package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2252_줄세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] pre = new int[N + 1];
		List<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		int temp1;
		int temp2;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			temp1 = Integer.parseInt(st.nextToken());
			temp2 = Integer.parseInt(st.nextToken());
			graph[temp1].add(temp2);
			pre[temp2]++;
		}
		
		StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<>();
		for(int i = 1 ; i < N + 1 ; i++) {
			if(pre[i] == 0) {
				que.add(i);
				sb.append(i);
				sb.append(" ");
			}
		}
		
		while(!que.isEmpty()) {
			temp1 = que.poll();
			for(int i : graph[temp1]) {
				pre[i]--;
				if(pre[i] == 0) {
					sb.append(i);
					sb.append(" ");
					que.add(i);
				}
			}
		}
		System.out.println(sb);
	}
}
