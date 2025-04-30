package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = N - 1;
		int mix;
		int min = 2000000000;
		int[] minIdx = new int[2];

		while (start < end) {
			mix = arr[start] + arr[end];
			
			if (Math.abs(mix) < min) {
				min = Math.abs(mix);
				minIdx[0] = start;
				minIdx[1] = end;
			}
			
			if (mix < 0) {
				start++;
			} else if (mix > 0) {
				end--;
			} else {
				break;
			}
		}

		System.out.println(arr[minIdx[0]] + " " + arr[minIdx[1]]);
	}
}
