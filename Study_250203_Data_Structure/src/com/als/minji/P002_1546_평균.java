package com.als.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P002_1546_평균 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		double[] nums = new double[N + 1];
		for(int i = 0 ; i < N ; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			nums[N] = Math.max(nums[N], nums[i]);
		}
		
		double avg = 0;
		for(int i = 0 ; i < N ; i++) {
			avg += nums[i] / nums[N] * 100;
		}
		System.out.println(avg / N);
	}
}
