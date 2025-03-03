package com.ssafy.yeook;

import java.util.Scanner;

public class 최대공약수_1850 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();

		long min = Math.min(a, b);
		long max = Math.max(a, b);
		long result = 1;

		while (true) {
			long s = max / min;
			long r = max % min;
			if (r == 0) {
				result = min;
				break;
			} else {
				max = min;
				min = r;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (long i = 0; i < result; i++) {
			sb.append(1);
		}
		System.out.println(sb.toString());
	}

}
