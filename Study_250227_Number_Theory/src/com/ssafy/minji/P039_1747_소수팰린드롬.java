package com.ssafy.minji;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P039_1747_소수팰린드롬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine().trim());
		String num = "";

		int[] arr = new int[1000001];
		arr[0] = 1;
		arr[1] = 1;
		for (int i = N; i <= 1000000; i++) {
			for (int j = i * 2; j <= 1000000; j += i) {
				arr[j] = 1;
			}
		}

		List<Integer> prime = new ArrayList<>();
		for (int i = N; i <= 1000000; i++) {
			if (arr[i] == 0) {
				prime.add(i);
			}
		}
		List<Integer> primePalin = new ArrayList<>();
		int maxPP = 0;
		for (int p : prime) {
			num = p + "";
			for (int i = 0; i <= (num.length() - 1) / 2; i++) {
				if (num.charAt(i) != num.charAt(num.length() - 1 - i)) {
					break;
				}
			}
			primePalin.add(p);
			maxPP = Math.max(maxPP, p);
		}
		System.out.println(maxPP);

		if (N <= maxPP) {
			for (int p : primePalin) {
				if (p >= N) {
					System.out.println(p);
					return;
				}
			}
		}
		
		int over = 1000001;
		nextLong: while (true) {
			for (int i : prime) {
				if (over % i == 0) {
					over++;
					continue nextLong;
				}
			}
			num = over + "";
			for (int i = 0; i <= (num.length() - 1) / 2; i++) {
				if (num.charAt(i) != num.charAt(num.length() - 1 - i)) {
					over++;
					continue nextLong;
				}
			}
			System.out.println(over);
			break;
		}
	}
}
