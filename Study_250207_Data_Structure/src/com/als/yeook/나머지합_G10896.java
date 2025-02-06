package com.als.yeook;

import java.io.*;
import java.util.*;

public class 나머지합_G10896 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st= new StringTokenizer(br.readLine());
		long []sum=new long[n];
		long []remains = new long[m];
		
		long count=0;

		for(int i = 0 ;i<n;i++) {
			if(i==0) sum[i]=Long.parseLong(st.nextToken());
			else sum[i]=sum[i-1]+Long.parseLong(st.nextToken());
			
			int remain=(int)(sum[i]%m);
			
			if(remain==0) count++;
			
			++remains[remain];
			
		}
		
		
		
		for(long c:remains) {
			if(c>1) {
				count+=c*(c-1)/2;
			}
		}
		
		
		bw.write(String.valueOf(count));
		bw.flush();
		
		
		
	}

}

