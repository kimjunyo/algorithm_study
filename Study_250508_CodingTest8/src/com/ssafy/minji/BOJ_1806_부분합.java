package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int min = N + 1;
		int start = 0;
		int sum = 0;

		for (int end = 0; end < N; end++) {
			sum += arr[end];

			while (sum >= S) {
				min = Math.min(min, end - start + 1);
				sum -= arr[start++];
			}
		}

		System.out.println(min == N + 1 ? 0 : min);
	}
}
