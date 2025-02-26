package com.ssafy.siyeong;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 수묶기_1744 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> positiveQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> negativeQ = new PriorityQueue<>();
		boolean haveZero = false;
		int res = 0;
		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			if (n > 0) {
				if (n == 1)
					res++;
				else
					positiveQ.add(n);
			} else if (n < 0) {
				negativeQ.add(n);
			} else
				haveZero = true;
		}
		int pSize = positiveQ.size() / 2;
		for (int i = 0; i < pSize; i++) {
			int n1 = positiveQ.poll();
			int n2 = positiveQ.poll();
			res += n1*n2;
		}
		int nSize = negativeQ.size() / 2;
		for (int i = 0; i < nSize; i++) {
			int n1 = negativeQ.poll();
			int n2 = negativeQ.poll();
			res += n1*n2;
		}
		if (!positiveQ.isEmpty()) {
			res += positiveQ.poll();
		}
		if (!negativeQ.isEmpty() && !haveZero) {
			res += negativeQ.poll();
		}
		System.out.println(res);

	}
}
