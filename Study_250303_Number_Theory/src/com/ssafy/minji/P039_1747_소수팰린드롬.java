package com.ssafy.minji;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P039_1747_소수팰린드롬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine().trim());
		if(N == 1) {
			System.out.println(2);
			return;
		}
		String num = "";

		List<Integer> prime = new ArrayList<Integer>();

		nextNum: for (int i = N; i <= 1003001; i++) {
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					continue nextNum;
				}
			}
			prime.add(i);
			num = i + "";
			for (int j = 0; j <= (num.length() - 1) / 2; j++) {
				if (num.charAt(j) != num.charAt(num.length() - 1 - j)) {
					continue nextNum;
				}
			}
			System.out.println(i);
			return;
		}
	}
}
