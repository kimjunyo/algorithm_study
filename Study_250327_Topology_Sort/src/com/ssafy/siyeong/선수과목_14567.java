package com.ssafy.siyeong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 선수과목_14567 {
	static int[] inDegree;
	static List<Integer>[] list;
	static int N;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		inDegree = new int[N + 1];
		list = new ArrayList[N + 1];
		result = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			//나를 가르키는 간선의 갯수
			inDegree[b]++;
		}
		
		topology();
		
		for (int i = 1; i <=N; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}

	private static void topology() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			}
		}
		int semester = 1;
		while (!q.isEmpty()) {
			int qSize = q.size();
			//한바퀴 돔
			for (int j = 0; j < qSize; j++) {
				int x = q.poll();
				result[x] = semester;
				for (int i = 0; i < list[x].size(); i++) {
					//내가 가르키는 곳 -1
					int y = list[x].get(i);
					if (--inDegree[y] == 0) {
						q.add(y);
					}
				}
			}
			//한층을 돌 때마다 학기 ++
			semester++;
		}

	}
}
