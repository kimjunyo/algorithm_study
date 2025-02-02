package com.als.yeook;
	import java.util.*;
	import java.io.*;

public class 숫자의합_B11720 {
	    public static void main(String[]args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int sum = 0;
	        int n = Integer.parseInt(st.nextToken());
	        st = new StringTokenizer(br.readLine());
	        String str = st.nextToken();
	        for(int i = 0;i<n;i++){
	            char num = str.charAt(i);
	            sum+=num-'0';
	        }
	        bw.write(String.valueOf(sum));
	        bw.flush();
	    }
	}


