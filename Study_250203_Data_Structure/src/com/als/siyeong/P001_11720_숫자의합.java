package com.als.siyeong;

import java.util.Scanner;

public class P001_11720_숫자의합 {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine();
		
		int result = 0;
		for (int i = 0; i < T; i++) {
			result += s.charAt(i) - '0';
		}
		System.out.println(result);
	}
}