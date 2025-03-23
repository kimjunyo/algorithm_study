package com.ssafy.siyeong;

import java.util.Scanner;

public class 집합의표현_1717 {
	static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			int command = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if (command == 0) {
				union(a, b);
			}
			else {
				System.out.println(isSame(a, b) ? "YES" : "NO");
			}
		}
	}
	
	private static boolean isSame(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) return true;
		else return false;
		
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
