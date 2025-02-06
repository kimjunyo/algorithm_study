package com.als.yeook;

import java.io.*;

import java.util.*;

public class 수들의합5_S2018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		for(int i = 0;i<n;i++) {
			arr[i]=i+1;
		}

		int startIndex = 0;
		int endIndex = 0;

		int count = 1;
		int sum = arr[0];
		while (endIndex < n-1) {
			if (sum == n) {
				count++;
				endIndex++;
				sum+=arr[endIndex];

			} else if (sum > n) {
				sum -= arr[startIndex];
				startIndex++;
			}else {
				endIndex++;
				sum+=arr[endIndex];
			}

		}
		bw.write(String.valueOf(count));
		bw.flush();
	}

}
