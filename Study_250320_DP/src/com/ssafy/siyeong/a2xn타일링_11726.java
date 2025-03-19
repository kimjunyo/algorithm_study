package com.ssafy.siyeong;

import java.util.Scanner;

public class a2xn타일링_11726 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long n1, n2, result;
		n1 = 1;
		n2 = 2;
		result = 3;
		for (int i = 3; i <= N; i++) {
			result = (n1 + n2) % 10007;
			n1 = n2;
			n2 = result;
		}
		if (N == 1) result = 1;
		else if (N == 2) result = 2;
		System.out.println(result);
	}
}
