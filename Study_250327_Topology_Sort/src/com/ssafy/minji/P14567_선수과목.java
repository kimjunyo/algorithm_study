package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14567_선수과목 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] pre = new int[N + 1];
		List<Integer>[] graph = new List[N + 1];
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

		int[] ans = new int[N + 1];		
		Queue<Integer> que = new LinkedList<>();
		for (int i = 1; i < N + 1; i++) {
			if(pre[i] == 0) {
				que.add(i);
				ans[i] = 1;
			}
		}
		
		while(!que.isEmpty()) {
			temp1 = que.poll();
			for(int i : graph[temp1]) {
				pre[i]--;
				if(pre[i] == 0) {
					que.add(i);
					ans[i] = ans[temp1] + 1;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i < N + 1 ; i++) {
			sb.append(ans[i]);
			sb.append(" ");
		}
		
		System.out.println(sb);
	}
}
