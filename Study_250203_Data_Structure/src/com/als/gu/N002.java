package com.als.gu;

import java.util.Scanner;

public class N002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double[] arr = new double[N];
		
		double M = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if (M > arr[i]) continue;
			M = arr[i];
		}
		
		double sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] /= M * 0.01;
			sum += arr[i];
		}
		
		System.out.println(sum / N);
	}
}
