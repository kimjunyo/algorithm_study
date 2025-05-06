package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long S = Long.parseLong(st.nextToken());
		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		int start = 0;
		int end = 0;
		long sum = arr[0];
		// 최소길이
		int length;
		// 조건 만족하는 수열 부분합 있는지.
		boolean isFind = sum >= S ? true : false;
		if (isFind)
			length = 1;
		else
			length = Integer.MAX_VALUE;

		while (start <= end && end < N) {
			if (sum >= S) {
				isFind = true;
				length = Math.min(end - start + 1, length);
				sum -= arr[start++];

			} else {
				end++;
				if (end >= N)
					break;
				sum += arr[end];

			}
		}

		if (isFind) {
			System.out.println(length);

		} else {
			System.out.println(0);

		}

	}
}
