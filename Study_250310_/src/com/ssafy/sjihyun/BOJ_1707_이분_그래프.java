package com.ssafy.sjihyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1707_이분_그래프 {
	static List<Integer>[] graph;
	static char[] visit;
	static boolean isBiGraph;
	
	private static void bfs(int num) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(num);
		visit[num]= 'A';
		
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int n : graph[node]) {
				if(visit[node] == visit[n]) {
					isBiGraph = false;
					return;
				}else if (visit[n] ==0) {
					q.offer(n);
					visit[n] = (visit[node] == 'A') ? 'B' : 'A';
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			st= new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[V+1];
			visit = new char[V+1];
			for(int i=1; i<=V; i++) {
				graph[i] = new ArrayList<>();
			}
			
			while(E>0) {
				st= new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph[u].add(v);
				graph[v].add(u);
				E--;
			}
		
			isBiGraph = true;
			for(int i=1; i<=V; i++) {
				if(visit[i] == 0) {
					bfs(i);
				}
				if(!isBiGraph) break;
			}
			
			if(isBiGraph) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		System.out.println(sb);
	}
}
