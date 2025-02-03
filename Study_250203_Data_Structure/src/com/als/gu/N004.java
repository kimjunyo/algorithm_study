package com.als.gu;

import java.util.Scanner;

public class N004 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] matrix = new int[N][N];
		int[][] sumMatrix = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt();
				for (int k = 0; k <= i; k++) {
					for (int l = 0; l <= j; l++) {
						sumMatrix[i][j] += matrix[k][l];
					}
				}
			}
			
		}
		
		
		for (int i = 0; i < M; i++) {
			int x1 = sc.nextInt() - 1;
			int y1 = sc.nextInt() - 1;
			int x2 = sc.nextInt() - 1;
			int y2 = sc.nextInt() - 1;
			
			System.out.println(sumMatrix[x2][y2] - sumMatrix[x1][y2] - sumMatrix[x2][y1] + sumMatrix[x1][y1]);
		}
	}
}
