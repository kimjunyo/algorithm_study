package com.ssafy.siyeong;

import java.util.Scanner;

public class 거짓말_1043_어려워 {
	static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		
	}
	
	private static int find(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) {
			if (a < b) {
				parent[b] = a;
			}
			else {
				parent[a] = b;
			}
		}
		
	}
}
