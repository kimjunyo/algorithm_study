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
		
		//모든 수들을 순회하며 자신을 좋은 수로 만드는 두 수가 있는지 확인.
		for (int curIndex = 0; curIndex < n; curIndex++) {
			 
			//후보의 두 수를 양끝에서 순회.
			int startIndex = 0;
			int endIndex = n-1;
			
			
			while(startIndex<endIndex) {
				//두 수가 좋은수를 만들면
				if(arr[startIndex]+arr[endIndex]==arr[curIndex]) {
					//자신을 좋은 수로 만드는 두 수에는 자신이 포함되면 안됨.
					if(startIndex!=curIndex&&endIndex!=curIndex) {
						count++;
						break;

					//두 수중 자신이 포함되면 그 수를 옮김.
					}else if(startIndex==curIndex) {
						startIndex++;
					}else {
						endIndex--;
					}

				//두 수의 합이 자신보다 작으면 작은 수인 startIndex이동	
				}else if(arr[startIndex]+arr[endIndex]<arr[curIndex]) {
					startIndex++;
				//두 수의 합이 자신보다 크면 큰 수인 endIndex이동	
				}else {
					endIndex--;
				}
			}

			

		}
		bw.write(String.valueOf(count));
		bw.flush();
	}

}
