package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 숨바꼭질3 {
	static int start, target;
	static int[] time;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());

		time = new int[100_001];
		visit = new boolean[100_001];
		Arrays.fill(time, Integer.MAX_VALUE);

		dijkstra();

		System.out.println(time[target]);
	}

	static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.add(new int[] { start, 0 });
		time[start] = 0;

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int x = now[0];
			int t = now[1];

			if (visit[x])
				continue;
			visit[x] = true;

			if (x == target)
				return;

			// 순간이동 (0초 소요)
			if (x * 2 <= 100000 && time[x * 2] > t) {
				time[x * 2] = t;
				pq.add(new int[] { x * 2, t });
			}

			// 앞으로 한 칸 (1초 소요)
			if (x + 1 <= 100000 && time[x + 1] > t + 1) {
				time[x + 1] = t + 1;
				pq.add(new int[] { x + 1, t + 1 });
			}

			// 뒤로 한 칸 (1초 소요)
			if (x - 1 >= 0 && time[x - 1] > t + 1) {
				time[x - 1] = t + 1;
				pq.add(new int[] { x - 1, t + 1 });
			}
		}
	}
}
