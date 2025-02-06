package com.als.gu;

import java.util.Arrays;
import java.util.Scanner;

public class N007_BOJ1940 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int l = 0;
		int r = N-1;
		int cnt = 0;
		while (l < r) {
			if ((arr[l] + arr[r]) > M) {
				r--;
			} else if ((arr[l] + arr[r]) < M) {
				l++;
			} else {
				cnt++;
				l++;
				r--;
			}
		}
		System.out.println(cnt);
	}
}
