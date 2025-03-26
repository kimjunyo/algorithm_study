package com.ssafy.junyeong.boj2252_줄세우기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static List<Integer>[] students;
	static int[] position;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		students = new ArrayList[N + 1];
		position = new int[N + 1];
		List<Integer> res = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			students[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			students[A].add(B);
			position[B]++;
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (position[i] == 0) {
				queue.add(i);
				position[i]--;
			}
		}

		while (!queue.isEmpty()) {
			int n = queue.size();

			for (int i = 0; i < n; i++) {
				int input = queue.poll();
				res.add(input);

				for (int j : students[input]) {
					position[j]--;
				}
			}
			
			for (int i = 1; i <= N; i++) {
				if (position[i] == 0) {
					queue.add(i);
					position[i]--;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i:res) {
			sb.append(i).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
