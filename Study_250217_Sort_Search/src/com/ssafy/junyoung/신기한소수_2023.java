package com.ssafy.junyoung;

import java.util.Scanner;

public class 신기한소수_2023 {
	static int N;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		dfs(N, 0);
		scan.close();
	}

	private static void dfs(int N, int sum) {
		if (sum / ((int)(Math.pow(10, N-1))) != 0) {
			System.out.println(sum);
			return;
		}

		for (int i = sum * 10 + 1; i < sum * 10 + 10; i++) {
			if (isPrime(i)) {
				dfs(N, i);
			}
		}
	}

	private static boolean isPrime(int i) {
		if(i==1) return false;
		
		for (int j = 2; j <= Math.sqrt(i); j++) {
			if (i % j == 0) {
				return false;
			}
		}
		return true;
	}
}