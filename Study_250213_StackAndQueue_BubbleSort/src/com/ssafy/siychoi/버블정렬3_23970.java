package com.ssafy.siychoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 버블정렬3_23970 {
	static int N;
	static int[] arrA;
	static int[] arrB;
	static boolean[] match;
	
	public static int bubbleSort() {
		for (int last = N; last > 0; last--) {
			for (int i = 0; i < last - 1; i++) {
				if (arrA[i] > arrA[i + 1]) {
					int temp = arrA[i];
					arrA[i] = arrA[i + 1];
					arrA[i + 1] = temp;
				}
				if (arrA[i] == arrB[i] && Arrays.equals(arrA, arrB)) return 1;
			}
		}
		return 0;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arrA = new int[N];
		arrB = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		match = new boolean[N];
		if (Arrays.equals(arrA, arrB)) {
			System.out.println(1);
			return;
		}
		System.out.println(bubbleSort());
	}
}
