package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		int start = 0;
		int end = n - 1;
		long min = Long.MAX_VALUE;
		StringBuilder result = new StringBuilder();
		if (arr[start] > 0) {
			System.out.println(arr[start] + " " + arr[start + 1]);
			return;
		}
		if (arr[end] < 0) {
			System.out.println(arr[end - 1] + " " + arr[end]);
			return;
		}

		while (start < end && min != 0) {
			long absStart = Math.abs(arr[start]);
			if (Math.abs(arr[start] + arr[end]) < min) {
				result = new StringBuilder().append(arr[start]).append(" ").append(arr[end]);
				min = Math.abs(arr[start] + arr[end]);
			}
			if (absStart > arr[end])
				start++;
			else
				end--;
		}
		System.out.println(result.toString().trim());

	}

}
