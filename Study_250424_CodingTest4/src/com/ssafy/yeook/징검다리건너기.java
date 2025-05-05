package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 징검다리건너기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		int[][] stepArr = new int[n + 1][3]; // 경우의 수 저장.
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			min = Math.min(stepArr[i - 1][0], stepArr[i - 1][1]);
			min = Math.min(stepArr[i - 1][2], min);
			stepArr[i][0] = arr[i] + min;
			stepArr[i][1] = stepArr[i - 1][0];
			stepArr[i][2] = stepArr[i - 1][1];
		}

		int min = Math.min(stepArr[n][0], stepArr[n][1]);
		min = Math.min(stepArr[n][2], min);
		System.out.println(min);
	}
}
