package com.ssafy.gu;

import java.util.Scanner;

public class BOJ1850 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		long gys = func(a, b);
		
		int ans = 0;
		for (int i = 0; i < gys; i++) {
			ans += Math.pow(10, i);
		}
		System.out.println(ans);
		
	}
	
	private static long func(long a, long b) {
		long bigger = Math.max(a, b);
		long smaller = Math.min(a, b);
		long mod = bigger % smaller;
		if (mod == 0) {
			return smaller;
		}
		
		return func(smaller, mod);
	}
}