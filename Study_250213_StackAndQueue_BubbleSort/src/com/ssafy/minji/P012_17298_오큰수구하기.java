package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P012_17298_오큰수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		Stack<Integer> idx = new Stack<>();

		arr[0] = Integer.parseInt(st.nextToken());
		idx.push(0);

		for (int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			while (!idx.empty() && arr[idx.lastElement()] < arr[i]) {
				arr[idx.pop()] = arr[i];
			}
			idx.push(i);
		}
		
		for(Integer i : idx) {
			arr[i] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++) {
			sb.append(arr[i] + " ");
		}
		
		System.out.println(sb);
	}
}
