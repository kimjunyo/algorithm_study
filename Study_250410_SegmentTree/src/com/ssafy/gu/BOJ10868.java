package com.ssafy.gu;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ10868 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, M;
		N = sc.nextInt();
		M = sc.nextInt();
		
		int treeDepth = (int) (Math.log(N)/Math.log(2)) + 1;
		int leafStart = (int) Math.pow(2, treeDepth);
		long[] tree = new long[leafStart*2];
		
		Arrays.fill(tree, 1000000001);
		
		for (int i = leafStart; i < leafStart+N; i++) {
			tree[i] = sc.nextLong();
		}
		
		for (int i = tree.length-1; i > 1; i--) {
			tree[i/2] = Math.min(tree[i/2], tree[i]);
		}
		
		for (int i = 0; i < M; i++) {
			long ans = 1000000001;
			int l = sc.nextInt() + leafStart - 1;
			int r = sc.nextInt() + leafStart - 1;
			while (l <= r) {
				if (l%2==1) {
					long min = tree[l];
					ans = Math.min(ans, min);
				}
				l = (l+1)/2;
				if (r%2==0) {
					long min = tree[r];
					ans = Math.min(ans, min);
				}
				r = (r-1)/2;
			}
			System.out.println(ans);
		}
		
	}
}
