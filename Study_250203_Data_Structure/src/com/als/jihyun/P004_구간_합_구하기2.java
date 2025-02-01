package com.als.jihyun;

import java.util.Scanner;

public class P004_구간_합_구하기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt()+1;
		int m = sc.nextInt();
		int[][] numArr = new int[n][n];
		int[][] sumArr = new int[n][n];
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<n; j++) {
				numArr[i][j] = sc.nextInt();
				sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1] + numArr[i][j]; 
			}
		}
		
		for(int i=0; i<m; i++) {	
			int[] coor = new int[5];
			for(int j=1; j<=4; j++) {
				coor[j] = sc.nextInt();
			}
			int sum = sumArr[coor[3]][coor[4]]  + sumArr[coor[1]-1][coor[2]-1]
					- sumArr[coor[3]][coor[2]-1] - sumArr[coor[1]-1][coor[4]];
			
			System.out.println(sum);
		}
	}
}
