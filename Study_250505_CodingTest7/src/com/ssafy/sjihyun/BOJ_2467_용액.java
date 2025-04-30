package com.ssafy.sjihyun;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

        int left = 0;
		int right = N - 1;
		int minAbsSum = Integer.MAX_VALUE;
		int[] result = new int[2];

		while (left < right) {
			int sum = arr[left] + arr[right];
			int absSum = Math.abs(sum);

			if (absSum < minAbsSum) {
				minAbsSum = absSum;
				result[0] = arr[left];
				result[1] = arr[right];
			}

			if (sum < 0) {
				left++;
			} else if (sum > 0) {
				right--;
			} else {
				break; 
			}
		}
		System.out.println(result[0] + " " + result[1]);
	}
}
