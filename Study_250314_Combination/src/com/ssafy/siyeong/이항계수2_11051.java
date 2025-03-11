package com.ssafy.siyeong;

import java.util.Scanner;

public class 이항계수2_11051 {
	static final int div = 10007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		System.out.println((factorial(N) * mod_inverse((factorial(N - K) * factorial(K)) % div, div - 2)) % div);
	}

	static int factorial(int N) {
		if (N <= 1) {
			return 1;
		}
		return (N * factorial(N - 1)) % div;
	}
 
	static int mod_inverse(int a, int p) {
		int ret = 1;
		while(p > 0) {
			if(p % 2 == 1) {
				ret *= a;
				p--;
				ret %= div;
			}
			a *= a;
			a %= div;
			p >>= 1;
		}
		return ret;
	}
}
