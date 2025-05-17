package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음악프로그램 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder result = new StringBuilder();
		int singers = Integer.parseInt(st.nextToken()); // 전체 가수의 수.
		int pds = Integer.parseInt(st.nextToken());
		int[] degree = new int[singers + 1];
		List<Integer>[] adjs = new ArrayList[singers + 1];
		for (int i = 1; i <= singers; i++) {
			adjs[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < pds; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int pre = Integer.parseInt(st.nextToken());
			int next = 0;
			while (st.hasMoreTokens()) {
				next = Integer.parseInt(st.nextToken());
				adjs[pre].add(next);
				degree[next]++;
				pre = next;

			}
		} // 진입차수, 인접 저장.
		int count = 0;
		Queue<Integer> needtovisit = new ArrayDeque<>();
		for (int i = 1; i <= singers; i++) {
			if (degree[i] == 0)
				needtovisit.add(i);
		}
		while (!needtovisit.isEmpty()) {
			int deque = needtovisit.poll();
			result.append(deque).append("\n");
			count++;
			for (int adj : adjs[deque]) {
				degree[adj]--;
				if (degree[adj] == 0)
					needtovisit.add(adj);
			}
		}
		if (count == singers)
			System.out.println(result.toString().trim());
		else
			System.out.println(0);
	}
}
