package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이중우선순위큐 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cases = Integer.parseInt(st.nextToken());
		for (int t = 0; t < cases; t++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());

			boolean[] visit = new boolean[k];

			// 최소 큐
			PriorityQueue<int[]> minpq = new PriorityQueue<>((a, b) -> {
				if (a[0] < b[0])
					return -1;
				else if (a[0] > b[0])
					return 1;
				// a[0] == b[0]
				if (a[1] < b[1])
					return -1;
				else if (a[1] > b[1])
					return 1;
				return 0;
			});

			// 최대 큐
			PriorityQueue<int[]> maxpq = new PriorityQueue<>((a, b) -> {
				if (a[0] > b[0])
					return -1;
				else if (a[0] < b[0])
					return 1;
				// a[0] == b[0]
				if (a[1] > b[1])
					return -1;
				else if (a[1] < b[1])
					return 1;
				return 0;
			});

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				char c = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				if (c == 'I') {
					int[] node = { num, i };
					minpq.add(node);
					maxpq.add(node);
				} else {
					if (num == -1) {
						while (minpq.size() > 0 && visit[minpq.peek()[1]]) {
							minpq.poll();
						}

						if (minpq.size() > 0) {
							int[] node = minpq.poll();
							visit[node[1]] = true;
						}
					} else {
						while (maxpq.size() > 0 && visit[maxpq.peek()[1]]) {
							maxpq.poll();
						}

						if (maxpq.size() > 0) {
							int[] node = maxpq.poll();
							visit[node[1]] = true;
						}

					}
				}

			} // for

			while (minpq.size() > 0 && visit[minpq.peek()[1]]) {
				minpq.poll();
			}
			while (maxpq.size() > 0 && visit[maxpq.peek()[1]]) {
				maxpq.poll();
			}
			if (minpq.size() > 0)
				result.append(maxpq.peek()[0]).append(" ").append(minpq.peek()[0]).append("\n");
			else
				result.append("EMPTY").append("\n");
			;

		}
		bw.write(result.toString().trim());
		bw.flush();
	}// main

}
