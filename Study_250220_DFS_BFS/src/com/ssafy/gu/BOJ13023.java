package com.ssafy.gu;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ13023 {
	static ArrayList[] friends;
	static boolean[] visited;
	static int depth = 0;
	static boolean isFound;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		friends = new ArrayList[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			friends[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			friends[s].add(e);
			friends[e].add(s);
		}
		
		for (int i = 0; i < N; i++) {
			if (isFound) return;
			DFS(i);
			visited[i] = false;
			depth--;
		}
		
		System.out.println(0);
		
	}

	private static void DFS(int i) {
		if (visited[i] || isFound) return;
		visited[i] = true;
		if (++depth == 5) {
			System.out.println(1);
			isFound = true;
		}
		
		for (Object v : friends[i]) {
			if (isFound) return;
			if (visited[(int)v]) continue;
			DFS((int)v);
			visited[(int)v] = false;
			depth--;
		}
	}
}
