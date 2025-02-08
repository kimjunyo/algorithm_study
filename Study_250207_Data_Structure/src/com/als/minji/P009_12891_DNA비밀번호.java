package com.als.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P009_12891_DNA비밀번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		String input = st.nextToken();
		byte[] arr = new byte[S];
		for(int i = 0 ; i < S ; i++	) {
			arr[i] = (byte)input.charAt(i);
		}
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		// A = 65, C = 67, G = 71, T = 84
		int[] dnaCnt = new int[85];
		int answer = 0;
		
		// 최초 부분문자열에서 count
		for(int i = 0 ; i < P ; i++) {
			dnaCnt[arr[i]]++;
		}
		// 최초 부분문자열 체크
		if(dnaCnt[65] >= a && dnaCnt[67] >= c && dnaCnt[71] >= g && dnaCnt[84] >= t) {
			answer++;
		}
		
		for(int i = P ; i < S ; i++) {
			dnaCnt[arr[i - P]]--;
			dnaCnt[arr[i]]++;
			
			if(dnaCnt[65] >= a && dnaCnt[67] >= c && dnaCnt[71] >= g && dnaCnt[84] >= t) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
