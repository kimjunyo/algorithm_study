package com.ssafy.gu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = 1;
		}
		
		Arrays.sort(arr, (a, b) -> a[0] - b[0]);
		
		int max = 0;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i][0] > arr[j][1] && arr[i][2] <= arr[j][2]) {
					arr[i][2] = arr[j][2]+1;
					max = Math.max(max, arr[i][2]);
				}
			}
		}
		
		System.out.println(max);

	}
}
