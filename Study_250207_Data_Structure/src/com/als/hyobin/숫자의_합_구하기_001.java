package com.als.hyobin;

import java.util.Scanner;

public class 숫자의_합_구하기_001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;
		for (char c : sc.next().toCharArray())
			result += c - '0';
		System.out.println(result);
	}
}