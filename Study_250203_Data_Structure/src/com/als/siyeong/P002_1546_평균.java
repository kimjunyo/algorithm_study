package com.als.siyeong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P002_1546_평균 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> numList = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			numList.add(sc.nextInt());
		}
		int M = Collections.max(numList);
		double result = 0;
		for (Integer n : numList) {
			result += ((double)n / (double)M) * 100;
		}
		System.out.println(result / N);
	}
}
