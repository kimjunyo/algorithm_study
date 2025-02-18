package com.ssafy.gu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P012_BOJ17298 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			stack.clear();
			for (int j = 0; j < N; j++) {
				stack.push(arr[j]);
			}
			int result = -1;
			for (int j = i; j < N; j++) {
				int pop = stack.pop();
				if (arr[i] < pop) {
					result = pop;
				}
			}
			sb.append(result);
			sb.append(" ");
		}
		System.out.print(sb);
		
	}
}
