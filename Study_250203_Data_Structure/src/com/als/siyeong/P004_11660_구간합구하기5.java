package com.als.siyeong;

import java.util.Scanner;

public class P004_11660_구간합구하기5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int[][] sumArr = new int [N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sumArr[i][j] = arr[i - 1][j - 1] + sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i-1][j-1];
			}
		}
		for (int i = 0; i < M; i++) {
			int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt();
			System.out.println(sumArr[x2][y2] - sumArr[x2][y1 - 1] - sumArr[x1 - 1][y2] + sumArr[x1-1][y1-1]);
		}
	}
}
