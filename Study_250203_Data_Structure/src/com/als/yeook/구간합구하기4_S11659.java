package com.als.yeook;
import java.util.*;
import java.io.*;
public class 구간합구하기4_S11659 {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int n = Integer.parseInt(st.nextToken());
	        int m = Integer.parseInt(st.nextToken());
	        int[] arr = new int[n];

	        StringTokenizer nums = new StringTokenizer(br.readLine());
	        for (int i = 0; i < n; i++) {
	            int num = Integer.parseInt(nums.nextToken());
	            if (i == 0) {
	                arr[i] = num;

	            } else {
	                arr[i] = arr[i - 1] + num;
	            }
	        }
	        StringBuilder result = new StringBuilder();
	        for (int i = 0; i < m; i++) {
	            StringTokenizer indexes = new StringTokenizer(br.readLine());
	            int start = Integer.parseInt(indexes.nextToken()) - 1;
	            int end = Integer.parseInt(indexes.nextToken()) - 1;
	            int sum = 0;
	            if (start == 0) {
	                result.append(arr[end]).append("\n");
	            } else {
	                result.append(arr[end] - arr[start - 1]).append("\n");
	            }
	        }
	        bw.write(result.toString().trim());
	        bw.flush();
	    }

}
