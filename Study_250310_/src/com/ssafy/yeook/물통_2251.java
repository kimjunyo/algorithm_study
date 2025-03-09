package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 물통_2251 {
	public static int a, b, c;
	public static Set<String> visit;
	public static Queue<int[]> needtovisit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		visit = new HashSet<>();
		needtovisit = new LinkedList<>();

		Set<Integer> result = new TreeSet<>();

		needtovisit.add(new int[] { 0, 0, c });
		visit.add("0 0 " + c);

		while (!needtovisit.isEmpty()) {
			int[] arr = needtovisit.poll();
			int x = arr[0], y = arr[1], z = arr[2];

			if (x == 0) {
				result.add(z);
			}

			// 가능한 모든 물 이동 시도
			move(needtovisit, visit, arr, x, y, z, a, b, 0, 1); // A -> B
			move(needtovisit, visit, arr, x, y, z, a, c, 0, 2); // A -> C
			move(needtovisit, visit, arr, x, y, z, b, a, 1, 0); // B -> A
			move(needtovisit, visit, arr, x, y, z, b, c, 1, 2); // B -> C
			move(needtovisit, visit, arr, x, y, z, c, a, 2, 0); // C -> A
			move(needtovisit, visit, arr, x, y, z, c, b, 2, 1); // C -> B
		}

		StringBuilder sb = new StringBuilder();
		for (int num : result) {
			sb.append(num).append(" ");
		}
		System.out.println(sb.toString().trim());
	}

	public static void move(Queue<int[]> queue, Set<String> visit, int[] arr, int x, int y, int z, int fromCap,
			int toCap, int from, int to) {
		int[] next = arr.clone();
		int amount = Math.min(next[from], toCap - next[to]); // 이동해야할 물의양
		next[from] -= amount; // 이동해야할 물의 양 빼기.
		next[to] += amount; // 물이동시키기.

		String state = next[0] + " " + next[1] + " " + next[2];
		if (!visit.contains(state)) { // 물통상태 저장하기.똑같은 경우 있으면 굳이 할필요없음.)
			visit.add(state);
			queue.add(next);
		}
	}
}
