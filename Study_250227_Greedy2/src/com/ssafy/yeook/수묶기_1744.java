package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 수묶기_1744 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		boolean zero = false;
		// 음수저장.작은수순서로 저장.
		PriorityQueue<Integer> neg = new PriorityQueue<>();
		// 양수저장. 큰수 순서로 저장.
		PriorityQueue<Integer> pos = new PriorityQueue<>((a, b) -> {
			return b - a;
		});
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			if (num == 0) {
				zero = true;
			} else if (num < 0) {
				neg.add(num);
			} else {
				pos.add(num);
			}
		}

		int sum = 0;
		while (neg.size() > 1) {
			sum += neg.poll() * neg.poll();
		}
		while (pos.size() > 1 && pos.peek() != 1) {
			int num1 = pos.poll();
			int num2 = pos.poll();
			if (num2 == 1) {
				sum += num1 + num2;
			} else {
				sum += num1 * num2;
			}
		}

		if (neg.size() == 1) {
			if (!zero)
				sum += neg.poll();
		}
		while (pos.size() > 0) {
			sum += pos.poll();
		}
		System.out.println(sum);

	}

}
