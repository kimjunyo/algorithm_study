package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 물통_2251 {
	public static int a;
	public static int b;
	public static int c;
	public static int[] arr;
	public static Set<String> visit;
	public static Queue<Integer> needtovisit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		// 물의 용량 저장.
		arr = new int[3];
		arr[2] = c;

		visit = new HashSet<>();
		needtovisit = new LinkedList<>();
		for (int i = 1; i <= 6; i++) {
			needtovisit.add(i);
		}
		Set<Integer> result = new HashSet<>();
		visit.add(Arrays.toString(arr));
		while (!needtovisit.isEmpty()) {
			int deque = needtovisit.poll();
			if (arr[0] == 0) {
				result.add(arr[2]);
			}
			if (move(deque)) {
				needtovisit.add(deque);
			}
			;
		}
		Integer[] r = result.toArray(new Integer[0]);

		Arrays.sort(r);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r.length; i++) {
			sb.append(r[i]).append(" ");
		}
		System.out.println(sb.toString().trim());

	}// main

	public static boolean move(int num) {
		int[] arr2 = Arrays.copyOf(arr, 3);
		switch (num) {
		// c->b
		case 1:
			return change(arr2, b, 2, 1);

		// c->a
		case 2:
			return change(arr2, a, 2, 0);

		// b->c
		case 3:
			return change(arr2, c, 1, 2);
		// b->a
		case 4:
			return change(arr2, a, 1, 0);
		// a->c
		case 5:
			return change(arr2, c, 0, 2);

		// a->b
		case 6:
			return change(arr2, b, 0, 1);

		default:
			return false;
		}
	}

	public static boolean change(int[] arr2, int capacity, int from, int to) {
		if (capacity - arr2[to] >= arr2[from]) {
			arr2[to] += arr2[from];
			arr2[from] = 0;
		} else {
			arr2[from] -= (capacity - arr2[to]);
			arr2[to] = capacity;
		}
		if (!visit.contains(Arrays.toString(arr2))) {
			visit.add(Arrays.toString(arr2));
			arr = arr2;
			return true;
		}
		return false;
	}

}
