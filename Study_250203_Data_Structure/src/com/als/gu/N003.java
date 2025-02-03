package com.als.gu;

import java.util.Scanner;

public class N003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		
        int[] sumArr = new int[N];
        int total = 0;
		for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sumArr[i] = (total += arr[i]);
        }
        
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			int end = e-1;
			int start = s-2;
			
			if (s-2 < 0) System.out.println(sumArr[end]);
			else System.out.println(sumArr[end] - sumArr[start]);
		}
	}
}
