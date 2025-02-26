package com.ssafy.gu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1744 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minus = new PriorityQueue<>((a,b) -> a-b);
		PriorityQueue<Integer> plus = new PriorityQueue<>((a,b) -> b-a);
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > 1) plus.add(num);
			else if (num <= 0) minus.add(num);
			else sum++;
		}
		
		while (minus.size() > 1) {
			sum += minus.poll()*minus.poll();
		}
		
		if (!minus.isEmpty()) {
			sum += minus.poll();
		}
		
		while (plus.size() > 1) {
			sum += plus.poll()*plus.poll();
		}
		
		if (!plus.isEmpty()) {
			sum += plus.poll();
		}
		
		System.out.println(sum);
	}
}
