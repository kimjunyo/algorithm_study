package com.als.siyeong;

import java.util.Scanner;

public class P003_11659_구간합구하기4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(), M = sc.nextInt();
		int[] numArr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			numArr[i] = numArr[i - 1] + sc.nextInt();
		}

		for (int i = 0; i < M; i++) {
			int start = sc.nextInt(), end = sc.nextInt();
			int result = numArr[end] - numArr[start - 1];
			System.out.println(result);
		}
	}
}
