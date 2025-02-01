package com.als.jihyun;

import java.util.Scanner;

public class P004_구간_합_구하기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt()+1;
		int m = sc.nextInt();
		int[][] numArr = new int[n][n];
		int[][] sumArr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				numArr[i][j] = (i==0 || j==0) ? 0 : sc.nextInt();
				sumArr[i][j] = (i==0 || j==0) ? 0 : numArr[i][j] + sumArr[i][j-1];
			}
		}
		
		for(int i=0; i<m; i++) {	
			int[] coor = new int[4];
			for(int j=0; j<4; j++) {
				coor[j] = sc.nextInt();
			}

			int sum =0;
			for(int j = coor[0]; j<=coor[2]; j++) {
				sum += sumArr[j][coor[3]]-sumArr[j][coor[1]-1];
			}
			System.out.println(sum);
		}
	}
}
