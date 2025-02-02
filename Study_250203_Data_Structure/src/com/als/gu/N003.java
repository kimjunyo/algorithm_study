package com.als.gu;

import java.util.Scanner;

public class N003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int sum = 0;
			for (int j = 0; j < e-s+1; j++) {
				sum += arr[s-1+j];
			}
			System.out.println(sum);
		}
	}
}
