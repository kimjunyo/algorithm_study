package com.ssafy.sjihyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343_기타_레슨 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int max=0,  min = 0;
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max += arr[i];
			min = Math.max(min, arr[i]);
		}
		
		int result = max;
		while(min<=max) {
			int cnt = 0, check = 0;
			int mid = (min+max)/2;
			
			for (int num : arr) {
			    if (check + num > mid) {
			        cnt++;
			        check = 0;
			    }
			    check += num;
			}

			if (check > 0) cnt++;
		
			if(cnt<=M) {
				max = mid-1;
				result = mid;
			}else  {
				min = mid+1;
			}
		}
		System.out.println(result);
	}
}
