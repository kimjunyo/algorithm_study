package com.ssafy.kyungmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_123더하기 {
	public static int[] onetwothree = { 1, 2, 3 };
	public static int N;
	public static int num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		while (tc++ < T) {
			num = 0;
			// 0 ~ 11
			N = Integer.parseInt(br.readLine());

			dp(0);

			System.out.println(num);
		}
	}

	/**
	 * 
	 * @param start 체크할 index
	 * @param acc   누적합
	 */
	public static void dp(int acc) {
		if (acc == N) {
			num++;
			return;
		}
		if (acc > N) {
			return;
		}
		for (int i = 0; i < onetwothree.length; i++) {
			dp(acc + onetwothree[i]);
		}
	}
}
