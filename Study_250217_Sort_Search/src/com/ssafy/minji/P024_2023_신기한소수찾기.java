package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P024_2023_신기한소수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		int[] firstDecimal = { 2, 3, 5, 7 };
		for (int i : firstDecimal) {
			DFS(i, N);
		}

	}

	static void DFS(int num, int N) {
		if (num >= Math.pow(10, N-1)) {
			System.out.println(num);
			return;
		}

		int nextNum = 0;
		for (int i = 1; i <= 9; i += 2) {
			nextNum = num * 10 + i;
			if (decimalCheck(nextNum)) {
				DFS(nextNum, N);
			}
		}
	}

	static boolean decimalCheck(int num) {
		if (num % 3 == 0) {
			return false;
		}

		for (int i = 5; i < num / 3; i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
