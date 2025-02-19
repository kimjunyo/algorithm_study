package com.ssafy.junyoung.ABCDE;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static boolean[] visited;
	static int N, num;
	static ArrayList<Integer>[] friends;
	static boolean isExist = false;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		friends = new ArrayList[N];

		int M = scan.nextInt();
		for (int i = 0; i < M; i++) {
			int idx = scan.nextInt();
			int nextIdx = scan.nextInt();
			if(friends[idx] == null) friends[idx] = new ArrayList<>();
			if(friends[nextIdx] == null) friends[nextIdx] = new ArrayList<>();
			
			friends[idx].add(nextIdx);
			friends[nextIdx].add(idx);
		}

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			num = 1;
			dfs(i);
			if(isExist) break;
		}
		if(isExist) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	private static void dfs(int i) {
		visited[i] = true;

		if (num == 5) {
			isExist = true;
			return;
		}

		if(friends[i] == null) {
			return;
		}
		
		for (int j : friends[i]) {
			if (visited[j] == false) {
				num++;
				dfs(j);
				num--;
				visited[j] = false;
			}
		}
	}
}
