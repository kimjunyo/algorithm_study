package com.ssafy.siyeong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 효율적인해킹_1325 {
	static int N;
	static int M;
	static int [][] arr;
	static boolean [] visited;
	static Set<Integer> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		
		for (int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[b][a] = 1;
		}
		set = new HashSet<Integer>();
		
		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			set.add(hacking(i, 1));
			visited[i] = false;
			
		}
		System.out.println(set);
		
		System.out.println(Arrays.toString(arr[0]));
		System.out.println(Arrays.toString(arr[1]));
		System.out.println(Arrays.toString(arr[2]));
		System.out.println(Arrays.toString(arr[3]));
	}
	private static int hacking(int n, int depth) {
		for (int i = 1; i <= N; i++) {
			if (arr[n][i] == 1 && !visited[n]) {
				visited[i] = true;
				hacking(i, depth + 1);
				visited[i] = false;
			}
		}
		return depth;
	}
}
