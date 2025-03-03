package com.ssafy.siyeong;

import java.util.Scanner;

public class 소수n팰린드롬_1747 {
	private static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isPalindrome(int n) {
		String s = Integer.toString(n);
		int sLen = s.length();
		for (int i = 0; i < sLen/2; i++) {
			if (s.charAt(i) != s.charAt(sLen - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while (true) {
			if (isPrime(N) && isPalindrome(N)) {
				System.out.println(N);
				return ;
			}
			N++;
		}
	}
}
