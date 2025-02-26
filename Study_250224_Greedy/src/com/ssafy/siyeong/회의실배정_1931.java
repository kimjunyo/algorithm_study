package com.ssafy.siyeong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 회의실배정_1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[i][0] = a;
			arr[i][1] = b;
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				//종료 시간이 같을 경우 시작시간이 빠른 순
				if (o1[1] == o2[1])
					return o1[0] - o2[0];
				
				return o1[1] - o2[1];
			}
		});
		
		int res = 0;
		int endTime = -1;

		for (int i = 0; i < N; i++) {
			if (arr[i][0] >= endTime) {
				res++;
				endTime = arr[i][1];
			}
        }
		System.out.println(res);
	}
}
