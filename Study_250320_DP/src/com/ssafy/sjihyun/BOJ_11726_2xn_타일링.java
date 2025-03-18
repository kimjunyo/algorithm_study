package com.ssafy.sjihyun;

import java.util.Scanner;

public class BOJ_11726_2xn_타일링 {
	static int[] field;
	private static int dp(int n) {
		if(n==1 || n==2 ) return n;
 		if(field[n] != 0) return field[n];
		
		return field[n] = (dp(n-1) + dp(n-2))%10007;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		field = new int[n+1];
		
		System.out.println(dp(n));
	}//
}
