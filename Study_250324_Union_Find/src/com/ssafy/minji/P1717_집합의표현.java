package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1717_집합의표현 {
	static int[] arr;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			arr[i] = i;
		}

		int caseNum = 0;
		int i = 0;
		int j = 0;
		for (int k = 0; k < m; k++) {
			st = new StringTokenizer(br.readLine());
			caseNum = Integer.parseInt(st.nextToken());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			
			if (caseNum == 0) {
				zero(i, j);
			} else {
				one(i, j);
			}
		}
	}

	static void zero(int i, int j) {
		// i가 j보다 크도록 설정
		if (i < j) {
			int temp = i;
			i = j;
			j = temp;
		}
		// 현재 i의 root와 i의 새로운 노드 간 관계 설정
		if (arr[i] != i) {
			zero(arr[i], j);
		}
		
		// i와 현재 i의 root에 대해 새로운 root 설정 : j == arr[i]일 때까지 반복
		do {
			arr[i] = arr[j];
			j = arr[j];
		} while (arr[j] != j);
	}

	static void one(int i, int j) {
		// i의 root 재탐색 및 설정
		do {
			arr[i] = arr[arr[i]];
			i = arr[i];
		} while (i != arr[i]);
		
		// j의 root 재탐색 및 설정
		do {
			arr[j] = arr[arr[j]];
			j = arr[j];
		} while (j != arr[j]);
		
		// 결과 출력
		if (arr[i] == arr[j]) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
