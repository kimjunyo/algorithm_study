package com.ssafy.siyeong;

import java.util.Scanner;

public class 기타레슨_2343 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[] arr = new int[N];
		int start = 0;
		int end = 0;
		
		for (int i = 0; i < N; i ++) {
			arr[i] = sc.nextInt();
			if (arr[i] > start) {
				start = arr[i];
			}
			end += arr[i];
		}
		int res = 0;
		
		while (start < end) {
			int mid = (start + end) >> 1;
			int count = 1;
			int total = 0;
			
			for (int n : arr) {
				if (total + n > mid) {
					total = 0;
					count++;
				}
				total+= n;
			}
			
			if (count <= M) {
				res = mid;
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		System.out.println(res);
	}
}
