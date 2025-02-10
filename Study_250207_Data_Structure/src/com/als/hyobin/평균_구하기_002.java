package com.als.hyobin;

import java.util.Scanner;

public class 평균_구하기_002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		int max = 0;
		int sum = 0;
		for (String s : sc.nextLine().split(" ")) {
			int num = Integer.parseInt(s);
			sum += num;
			max = (max < num) ? num : max;
		}
		double average = (double) sum * 100 / max / N;
		System.out.println(average);
	}
}
