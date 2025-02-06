package com.als.yeook;

import java.io.*;
import java.util.*;

public class 좋다_G1253 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int count = 0;
		
		for (int curIndex = 0; curIndex < n; curIndex++) {
			 
			int startIndex = 0;
			int endIndex = n-1;
			
			while(startIndex<endIndex) {
				if(arr[startIndex]+arr[endIndex]==arr[curIndex]) {
					if(startIndex!=curIndex&&endIndex!=curIndex) {
						count++;
						break;
					
					}else if(startIndex==curIndex) {
						startIndex++;
						
					}else {
						endIndex--;
					}
				}else if(arr[startIndex]+arr[endIndex]<arr[curIndex]) {
					startIndex++;
				}else {
					endIndex--;
				}
			}

			

		}
		bw.write(String.valueOf(count));
		bw.flush();
	}

}
