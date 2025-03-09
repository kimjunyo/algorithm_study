package com.ssafy.gu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1325 {
	static List<Integer>[] conns;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		conns = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			conns[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			conns[b].add(a);
		}
		
		int[] hackCnt = new int[N+1];
		
		int max = 0;
		for (int i = 1; i < N+1; i++) {
			hackCnt[i] = bfs(i);
			max = Math.max(max, hackCnt[i]);
		}
		for (int i = 1; i < N+1; i++) {
			if (hackCnt[i] == max) System.out.print(i + " ");
		}
		
	}

	private static int bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		int b = 0;
		while (!q.isEmpty()) {
			int com = q.poll();
			b++;
			for (int i = 0; i < conns[com].size(); i++) {
				q.add(conns[com].get(i));
			}
		}
		
		return b;
	}
}
