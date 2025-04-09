package com.ssafy.gu;

import java.util.Scanner;

public class BOJ2042 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, M, K;
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		int power = 1;
		int tmp = N;
		while (tmp > 1) {
			tmp /= 2;
			power++;
		}
		
		int leafStart = (int)Math.pow(2, power);
		long[] tree = new long[leafStart*2];
		
		for (int i = leafStart; i < leafStart+N; i++) {
			tree[i] = sc.nextLong();
		}
		
		for (int i = tree.length-1; i > 1; i--) {
			tree[i/2] += tree[i];
		}
		
		for (int i = 0; i < M+K; i++) {
			if (sc.nextInt() == 1) {
				int b = sc.nextInt();
				long c = sc.nextLong();
				int idx = b+leafStart-1;
				long change = c - tree[idx];
				tree[idx] = c;
				
				while (idx > 1) {
					idx /= 2;
					tree[idx] += change;
				}
			} else {
				int b = sc.nextInt();
				int c = sc.nextInt();
				int l = b+leafStart-1;
				int r = c+leafStart-1;
				long sum = 0;
				
				while (l <= r) {
					if (l%2 == 1) sum += tree[l];
					l = (l+1)/2;
					if (r%2 == 0) sum += tree[r];
					r = (r-1)/2;
				}
				System.out.println(sum);
			}
		}
	}
}
