package com.als.gu;

import java.util.Arrays;
import java.util.Scanner;

public class N008_BOJ1253 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int cnt = 0;
		for (int i = 2; i < N; i++) {
			int l = 0;
			int r = i-1;
			
			while (l < r) {
				if (arr[r] + arr[l] > arr[i]) {
					r--;
				} else if (arr[r] + arr[l] < arr[i]) {
					l++;
				} else {
					cnt++;
					break;
				}
			}
			
		}
		
		System.out.println(cnt);
	}
}
