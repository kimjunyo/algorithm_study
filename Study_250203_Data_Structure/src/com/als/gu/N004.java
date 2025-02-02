package com.als.gu;

import java.util.Scanner;

public class N004 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] matrix = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < M; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int sum = 0;
			for (int j = x1-1; j < x2; j++) {
				for (int k = y1-1; k < y2; k++) {
					sum += matrix[j][k];
				}
			}
			System.out.println(sum);
		}
	}
}
