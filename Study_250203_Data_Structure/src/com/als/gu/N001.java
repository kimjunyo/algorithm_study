package com.als.gu;

import java.util.Scanner;

public class N001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String num = sc.next();
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += num.charAt(i) - '0';
		}
		
		System.out.println(sum);
	}
}
