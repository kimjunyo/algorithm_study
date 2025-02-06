package com.als.hyobin;

import java.util.Scanner;

public class P006_수들의_합5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		if (N == 1) {
			System.out.println(1);
			return;
		}

		int count = 0;
		for (int i = 1; i < N / 2 + 1; i += 2) {
			int n = N / i;

			if (n - i / 2 <= 0)
				break;

			if (N % i == 0)
				count++;
		}

		for (int i = 2; i <= N / 2 + 1; i += 2) {
			int n = N / i;

			if (n - i / 2 + 1 <= 0)
				break;

			if (i * n + i / 2 == N)
				count++;
		}

		System.out.println(count);
		sc.close();
	}

}
