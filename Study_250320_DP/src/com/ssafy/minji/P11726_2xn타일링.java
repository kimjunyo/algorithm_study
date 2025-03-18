package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11726_2xn타일링 {
	static int N;
	static int k;
	static long[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = 10007;
		N = Integer.parseInt(br.readLine().trim());
		arr = new long[N + 1];
		arr[1] = 1;
		if (N > 1) {
			arr[2] = 2;
			if (N > 2)
				fibo(3);
		}
		System.out.println(arr[N]);
	}

	static void fibo(int idx) {
		if (idx == N + 1) {
			return;
		}
		arr[idx] = (arr[idx - 2] + arr[idx - 1]) % k;
		fibo(idx + 1);
	}
}
