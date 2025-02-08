package com.als.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P008_1253_좋다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		long[] arr = new long[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int p1 = 0;
		int p2 = N-1;
		long sum = 0;
		int cnt = 0;
		for(int i = 0 ; i < N ; i++) {
			p1 = 0;
			p2 = N-1;
			
			do {
				sum = arr[p1] + arr[p2];
				if(sum > arr[i]) {
					p2--;
				}else if(sum < arr[i]) {
					p1++;
				}else {
					if(p1 == i){
						p1++;
					}else if(p2 == i){
						p2--;
					}else {
						cnt++;
						break;
					}
				}
			}while(p1 < p2);
		}
		System.out.println(cnt);
	}
}
