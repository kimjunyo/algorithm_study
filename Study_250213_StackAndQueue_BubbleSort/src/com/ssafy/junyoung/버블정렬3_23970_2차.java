package com.ssafy.junyoung;

import java.io.*;
import java.util.*;

public class 버블정렬3_23970_2차 {

	static int[] A;
	static int[] B;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		A = new int[N];
		B = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		if (Arrays.equals(A, B)) {
			System.out.println(1);
			return;
		}

		System.out.println(bubbleSort());
	}

	private static int bubbleSort() {
		for (int i = N - 1; i >= 1; i--) {
			for (int j = 0; j < i; j++) {
				if (A[j] > A[j + 1]) {
					int tmp = A[j + 1];
					A[j + 1] = A[j];
					A[j] = tmp;
					if (A[j] == B[j] && A[j + 1] == B[j + 1] && Arrays.equals(A, B))
						return 1;
				}

			}
		}
		return 0;

	}

}
