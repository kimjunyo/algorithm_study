package com.als.jihyun;

import java.util.Scanner;

public class P003_구간_합_구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt()+1;
		int m = sc.nextInt();
		int[] numArr = new int[n];
		int[] sumArr = new int[n];
		
		for(int i=1; i<n; i++) {
			numArr[i] = sc.nextInt();
			sumArr[i] = numArr[i] + sumArr[i-1];
		}

		for(int i=0; i<m; i++) {
			int start = sc.nextInt()-1;
			int end = sc.nextInt();	
			System.out.println(sumArr[end]-sumArr[start]);
		}		
	}
}
