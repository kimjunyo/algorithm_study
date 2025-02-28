package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P030_2343_기타레슨 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int start = 0;
		int end = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			end += arr[i];
			if(start < arr[i]) {
				start = arr[i];
			}
		}

		int mid = 0;
		int ray = 0;
		int cnt = 1;
		while(start <= end) {
			mid = (start + end) / 2;
			ray = 0;
			cnt = 1;
			for(int i = 0 ;i < N ; i++) {
				if(cnt > M) {
					break;
				}
				if(ray + arr[i] <= mid) {
					ray += arr[i];
				}else {
					ray = arr[i];
					cnt++;
				}
			}
			if(cnt <= M) {
				end = mid - 1;
			}else{
				start = mid + 1;
			}
		}
		System.out.println(start);
	}
}
