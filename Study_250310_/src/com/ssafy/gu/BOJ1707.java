package com.ssafy.gu;

import java.util.Scanner;

public class BOJ1707 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		for (int i = 0; i < K; i++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			for (int j = 0; i < E; i++) {
				sc.nextInt();
				sc.nextInt();
			}
			if (V > E) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
