package com.ssafy.yeook;

import java.util.Scanner;

public class 소수와팰린드롬_1747 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] prime = new boolean[1100001]; // false =소수
		prime[0] = prime[1] = true;

		for (int i = 2; i <= Math.sqrt(1100000); i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= 1100000; j += i) {
					prime[j] = true;
				}
			}
		} // 소수저장.

		for (int i = n; i <= 1100000; i++) {
			if (!prime[i]) {
				String str = String.valueOf(i);
				int s = 0;
				int e = str.length() - 1;
				int m = str.length() / 2;
				boolean isOk = true;
				while (s < e) {
					if (str.charAt(s) != str.charAt(e)) {
						isOk = false;
						break;
					}
					s++;
					e--;
				}
				if (isOk) {
					System.out.println(i);
					return;
				}
			}
		}
	}

}
