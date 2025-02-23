package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P33_1715_카드정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
		}

		if(N == 1) {
			System.out.println(arr[0]);
			return;
		}else if(N == 2) {
			System.out.println(arr[0] + arr[1]);
			return;
		}
		
		Arrays.sort(arr);
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i = 0 ; i < N ; i++) {
			que.add(arr[i]);
		}
		
		int sum = que.poll() + que.poll();
		int temp = 0;
		for(int i = 2 ; i < N ; i++) {
			temp = que.poll();
			if(que.peek() < sum) {
				
			}
		}
		System.out.println(sum);
	}
}
