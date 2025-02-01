package com.als.junyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의_합_구하기_001 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		br.readLine();
		String number = br.readLine();
		char[] nCA = number.toCharArray();
		int sum = 0;
		
		for(char c : nCA) {
			sum += c-'0';
		}
		
		System.out.println(sum);
	}
}
