package com.als.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P001_11720_숫자의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int sum = 0;
		for(int i = 0 ; i < N ; i++) {
			sum += input.charAt(i) - '0';
		}
		System.out.println(sum);
	}
}