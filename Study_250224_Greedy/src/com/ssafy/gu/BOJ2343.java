package com.ssafy.gu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2343 {
	static int N;
	static int M;
	static int[] lectures;
	static boolean[] visited;
	static int[] combination;
	static int depth;
	static int idx;
	static int maxSum;
	static int m;
	static int discSize = 10000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lectures = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			lectures[i] = Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean[N];
		combination = new int[M-1];
		
		comb(0, 1);
		
		System.out.println(discSize);
	}
	
	private static void comb(int depth, int idx) {
		if (depth == M-1) {
			maxSum = 0;
			m = 0;
			
			int temp = 0;
			while (m < M) {
				int sum = 0;
				for (int i = temp; i < N; i++) {
					sum += lectures[i];
					if (m != M-1 && i == combination[m]) {
						temp = i+1;
						break;
					}
				}
				maxSum = Math.max(maxSum, sum);
				m++;
			}
			
			discSize = Math.min(discSize, maxSum);
			return;
		}
		
		for (int i = idx; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			combination[depth] = i;
			comb(depth+1, i+1);
			visited[i] = false;
		}
	}
}
