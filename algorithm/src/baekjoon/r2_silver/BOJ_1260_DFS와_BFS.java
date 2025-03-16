package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와_BFS {
	
	static int N;
	static List<Integer>[] graph;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	private static void bfs(int node) {
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(node);
		visit[node] = true;
		
		while(!q.isEmpty()) {
			int num = q.poll();
			for(int n : graph[num]) {
				if(!visit[n]) {
					visit[n] = true;
					q.offer(n);
					sb.append(n).append(" ");
				}
			}
		}
	}
	
	private static void dfs(int node) {
		visit[node] = true;
		
		for(int n : graph[node]) {
			if(!visit[n]) {
				sb.append(n).append(" ");
				dfs(n);
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		visit = new boolean[N+1];
		
		for(int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for(int i=1; i<N+1; i++) {
			Collections.sort(graph[i]);
		}
		
		sb.append(V).append(" ");
		dfs(V);
		System.out.println(sb);
		sb.setLength(0);
		
		
		visit = new boolean[N+1];
		sb.append(V).append(" ");
		bfs(V);
		System.out.println(sb);
	}
}
