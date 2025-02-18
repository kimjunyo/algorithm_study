package com.ssafy.jihyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE_13023 {
	
	static List<Integer>[] friend;
	static boolean[] visited;
	
	private static boolean dfs(int i, int depth) {
		if(depth ==5) return true;

		
		visited[i] = true;
		for(int a : friend[i]) {
			if(!visited[a]) {
				if(dfs(a, depth+1)) {
					return true;
				}
			}
		}
		visited[i] = false;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		friend = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			friend[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			friend[u].add(v);
			friend[v].add(u);
		}
		
		for (int i = 0; i < N; i++) {
		    if (dfs(i, 1)) {
		        System.out.println(1);
		        return;
		    }
		}
		System.out.println(0);
	}
}