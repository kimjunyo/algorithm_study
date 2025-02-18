package com.ssafy.jihyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와_BFS {
	
	static int N;
	static int M;
	static int V;
	
	static List<Integer>[] list;
	static boolean[] visited;
	static Deque<Integer> deque = new ArrayDeque<>();
	
	
	private static void dfs(int num) {
		if(visited[num]) return;
		
		visited[num] = true;
		System.out.print(num+ " ");
		
		for(int a : list[num]) {
			if(!visited[a]) dfs(a);
		}
	}
	
	private static void bfs(int num) {
		deque.offerLast(num);
		visited[num] = true;
		
		while(!deque.isEmpty()) {
			int point = deque.pollFirst();
			System.out.print(point+ " ");
			
			for(int a : list[point]) {
				if(!visited[a]) {
					visited[a] = true;
					deque.offerLast(a);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		//System.out.println("N M V     " + N + " "+ M + " "+ V + " ");
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		//System.out.println(Arrays.toString(list));
		
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[u].add(v);
			list[v].add(u);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(list[i]);
		}
		
		dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V);
	}
}
