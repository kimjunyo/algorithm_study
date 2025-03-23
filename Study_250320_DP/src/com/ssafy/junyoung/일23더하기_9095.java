package com.ssafy.junyoung;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 일23더하기_9095 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		int[] res = new int[11];
		res[1] = 1;
		res[2] = 2;
		res[3] = 4;
		for (int i = 4; i < 11; i++) {
			res[i] = res[i - 1] + res[i - 2] + res[i - 3];
		}

		for (int i = 0; i < TC; i++) {
			int N = Integer.parseInt(br.readLine());

			if (N <= 0) {
				System.out.println(0);
				continue;
			}
			
			System.out.println(res[N]);
		}
	}
}
