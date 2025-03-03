package com.ssafy.siyeong;

import java.util.Scanner;

public class 최대공약수_1850 {
	private static long 최대공약수(long a, long b) {
		if (b == 0) {
			return a;
		} else {
			return 최대공약수(b, a % b);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		StringBuilder br = new StringBuilder();
		long n = 최대공약수(a, b);
		for (int i = 0; i < n; i++) {
			br.append('1');
		}
		System.out.println(br);
	}
}
