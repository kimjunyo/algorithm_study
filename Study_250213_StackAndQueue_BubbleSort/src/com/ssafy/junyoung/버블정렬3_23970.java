package com.ssafy.junyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 버블정렬3_23970 {
	static int[] A;
	static int[] B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

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

		// 1. A 정렬
		int[] sortArr = A.clone();
		bubbleSort(sortArr);

		int idx = 0;

		// 2. B에서 정렬된 부분 제외 -> A에서도 삭제
		for (int i = N - 1; i >= 0; i--) {
			if (sortArr[i] == B[i]) {
				idx++;
				B[i] = 0;
			} else {
				break;
			}
		}

		for (int i = 0; i < idx; i++) {
			for (int j = 0; j < N; j++) {
				if (sortArr[N - 1 - i] == A[j]) {
					A[j] = 0;
				}
			}
		}

		// 3. A, B에서 남은배열의 최댓값 구하기 -> 삭
		int maxB = 0;
		int maxBIdx = 0;
		for (int i = 0; i < N - idx; i++) {
			if (maxB < B[i]) {
				maxB = B[i];
				maxBIdx = i;
			}
		}

		int maxA = 0;
		int maxAIdx = 0;
		for (int i = 0; i < N - idx; i++) {
			if (maxA < A[i]) {
				maxA = A[i];
				maxAIdx = i;
			}
		}

		if (maxA != maxB) {
			System.out.println(0);
			return;
		}

		A[maxAIdx] = 0;
		B[maxBIdx] = 0;

		// 4. 0이 아닌 것만 남겨서 배열 비교.
		int[] notZeroA = new int[N - idx - 1];
		int[] notZeroB = new int[N - idx - 1];

		maxAIdx = 0;
		maxBIdx = 0;

		for (int i = 0; i < N; i++) {
			if (A[i] != 0) {
				notZeroA[maxAIdx++] = A[i];
			}

			if (B[i] != 0) {
				notZeroB[maxBIdx++] = B[i];
			}
		}

		for (int i = 0; i < N - idx - 1; i++) {
			if (notZeroA[i] != notZeroB[i]) {
				System.out.println(0);
				return;
			}
		}

		System.out.println(1);
	}

	private static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}

	}

}
