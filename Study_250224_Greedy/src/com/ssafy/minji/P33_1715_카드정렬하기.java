package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P33_1715_카드정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			que.add(Integer.parseInt(br.readLine().trim()));
		}
		int sum = 0;
		int ans = 0;
		while (que.size() > 1) {
			sum = que.poll() + que.poll();
			ans += sum;
			que.add(sum);
		}

		System.out.println(ans);
	}
}
