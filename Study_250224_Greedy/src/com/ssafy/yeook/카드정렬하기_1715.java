package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 카드정렬하기_1715 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			heap.add(Integer.parseInt(new StringTokenizer(br.readLine()).nextToken()));
		}
		int total = 0;
		while (heap.size() > 1) {
			int num1 = heap.poll();
			int num2 = heap.poll();
			int sum = num1 + num2;
			heap.add(sum);
			total += sum;
		}
		System.out.println(total);
	}

}
