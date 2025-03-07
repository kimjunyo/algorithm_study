package com.ssafy.sjihyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325_효율적인_해킹 {
	
	static List<Integer>[] graph;
	static boolean[] visit;
	static int[] cnt;
	
	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int n : graph[node]) {
				if(!visit[n]) {
					cnt[start]++;
					q.offer(n);
					visit[n] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		cnt = new int[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[v].add(u); //역방향 그래프
		}
		
		//System.out.println(Arrays.toString(graph));
		
		for(int i=1; i<=N; i++) {
			visit = new boolean[N+1];
			bfs(i);
		}
		
		//System.out.println(Arrays.toString(cnt));
		int max = cnt[0];
		for(int n : cnt) max = Math.max(max, n);
		for(int i=1; i<N+1; i++) {
			if(cnt[i] == max) sb.append(i).append(" ");
		}
		
		System.out.println(sb);
	}
}
