package com.ssafy.sjihyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	
	static List<Integer>[] graph;
	static boolean[] visit;
	static int cnt;
	
	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		visit[start] = true;
		q.offer(1);
		
		while(!q.isEmpty()) {
			
			int node = q.poll();
			for(int n : graph[node]) {
				if(!visit[n]) {
					visit[n] = true;
					q.offer(n);
					cnt++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V+1];
		visit = new boolean[V+1];
		
		for(int i=0; i<V+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		cnt = 0;
		bfs(1);
		System.out.println(cnt);
	}
}