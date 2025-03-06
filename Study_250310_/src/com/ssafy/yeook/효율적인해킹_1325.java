
package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 효율적인해킹_1325 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());// 컴퓨터갯수
		int m = Integer.parseInt(st.nextToken());// 엣지갯수
		List<Integer>[] nodes = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			nodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// b해킹하면 a도 해킹할 수 있음.
			nodes[b].add(a);
		}

		// 인덱스 = 노드번호, 해당 노드가 해킹을 당했을 때 해킹할 수 있는 노드의 카운트를 증가시킴.
		int[] hacking = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			Queue<Integer> needtovisit = new LinkedList<>();
			boolean[] visit = new boolean[n + 1];

			needtovisit.add(i);
			visit[i] = true;

			while (!needtovisit.isEmpty()) {
				int deque = needtovisit.poll();

				for (int child : nodes[deque]) {
					if (!visit[child]) {
						needtovisit.add(child);
						visit[child] = true;
						hacking[i]++;

					}
				}
			}
		}
		int max = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, hacking[i]);
		}
		for (int i = 1; i <= n; i++) {
			if (max == hacking[i]) {
				sb.append(i).append(" ");
			}
		}
		bw.write(sb.toString().trim());
		bw.flush();
	}

}
