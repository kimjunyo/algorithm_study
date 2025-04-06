package com.ssafy.gu;

import java.util.Scanner;

public class BOJ11404 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n+1][n+1];
		
		final int INF = Integer.MAX_VALUE;
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if (i == j) map[i][j] = 0;
				else map[i][j] = INF;
			}
		}
		
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int time = sc.nextInt();
			
			map[s][e] = Math.min(map[s][e], time);
		}
		
		for (int k = 1; k < n+1; k++) {
			for (int i = 1; i < n+1; i++) {
				if (map[i][k] == INF) continue;
				for (int j = 1; j < n+1 ;j++) {
					if (map[k][j] == INF) continue;
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if (map[i][j] == INF) System.out.print(0 + " ");
				else System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
