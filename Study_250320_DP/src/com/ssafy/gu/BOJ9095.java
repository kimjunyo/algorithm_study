package com.ssafy.gu;

import java.util.Scanner;

public class BOJ9095 {
	static int[] arr = {1,2,3};
	static int n;
	static int sum;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			n = sc.nextInt();
			sum = 0;
			cnt = 0;
			perm(0,0);
			System.out.println(cnt);
		}
	}

	private static void perm(int idx, int sum) {
		if (idx == 3 || sum > n) return;
		if (sum == n) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			perm(i, sum+arr[i]);
		}
	}
}
