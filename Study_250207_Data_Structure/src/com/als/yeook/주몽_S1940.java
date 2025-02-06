package com.als.yeook;

import java.io.*;
import java.util.*;

public class 주몽_S1940 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int []arr = new int[n];
		for(int i = 0;i<n;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int startIndex=0;
		int endIndex = n-1;
		int sum=arr[startIndex]+arr[endIndex];
		int count=0;
		while(startIndex<endIndex) {
			if(sum==m) {
				count++;
				sum=arr[++startIndex]+arr[--endIndex];
			}else if(sum<m){
				sum=arr[++startIndex]+arr[endIndex];
			
			}else {
				sum=arr[startIndex]+arr[--endIndex];

			}
			
		}
		bw.write(String.valueOf(count));
		bw.flush();
		
	
	}

}
