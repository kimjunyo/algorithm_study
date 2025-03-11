package com.ssafy.siyeong;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class 물통_2251 {
	static int[] bottles = new int[3];
	static Set<Integer> answer = new TreeSet<>();
	static boolean[][] check = new boolean[201][201];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			bottles[i] = sc.nextInt();
		}
		dfs(0, 0, bottles[2]);
		for (int n : answer) {
			System.out.print(n + " ");
		}
	}
	
	static void dfs(int a, int b, int c) {
		if (check[a][b]) return;
		check[a][b] = true;
		if (a == 0) {
			answer.add(c);
		}
//		a -> b
		if (a + b > bottles[1]) {
			dfs(a + b - bottles[1], bottles[1], c);
		}
		else {
			dfs(0, a + b, c);
		}
//		b -> a
		if (a + b > bottles[0]) {
			dfs(bottles[0], a + b - bottles[0], c);
		}
		else {
			dfs(a + b, 0, c);
		}
//		a -> c
		if (a + c > bottles[2]) {
			dfs(a + c - bottles[2], b, bottles[2]);
		}
		else {
			dfs(0, b, a + c);
		}
//		c -> a
		if (a + c > bottles[0]) {
			dfs(bottles[0], b, a + c - bottles[0]);
		}
		else {
			dfs(a + c, b, 0);
		}
//		b -> c
		if (b + c > bottles[2] ) {
			dfs(a, b + c - bottles[2], bottles[2]);
		}
		else {
			dfs(a, 0, b + c);
		}
//		c -> b
		if (b + c > bottles[1]) {
			dfs(a, bottles[1], b + c - bottles[1]);
		}
		else {
			dfs(a, b + c, 0);
		}
	}
}