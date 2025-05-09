package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LCS {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringBuilder result = new StringBuilder();
		StringBuilder str1 = new StringBuilder(br.readLine());
		StringBuilder str2 = new StringBuilder(br.readLine());
		int[][] arr = new int[str2.length()][str1.length()];
		int max = 0;
		for (int s2 = 0; s2 < str2.length(); s2++) {
			for (int s1 = 0; s1 < str1.length(); s1++) {
				int count = 0;

				if (str1.charAt(s1) == str2.charAt(s2)) {

					count++;
				}
				if (s1 > 0 && s2 > 0) {
					count += arr[s2 - 1][s1 - 1];
				}

				if (s2 > 0) {
					count = Math.max(count, arr[s2 - 1][s1]);
				}

				if (s1 > 0) {
					count = Math.max(count, arr[s2][s1 - 1]);
				}

				arr[s2][s1] = count;
				max = Math.max(max, count);

			}
		}

		System.out.println(max);

	}// main

}
