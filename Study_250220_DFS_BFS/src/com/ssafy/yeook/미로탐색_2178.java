package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 미로탐색_2178 {
	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 행의 갯수
		int m = Integer.parseInt(st.nextToken()); // 열의 갯수
		// 주어진 배열 저장.
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = new StringTokenizer(br.readLine()).nextToken();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		// 방문할 정점을 저장.
		/*
		 * 각 좌표를 숫자좌표로 저장. 숫좌표 = x*m+y ) 0 1 2 3 4 5 6 7 8 9 10 11 ...
		 * 
		 */
		Set<Integer> visitSet = new HashSet<>();

		// BFS
		Set<Integer> needtovisitSet = new HashSet<>(); // 방문할 정점을 추가할 때, 중복추가 안하려고 방문할 정점을 저장한 set도 만듦
		visitSet.clear();

		// 방문할 정점.
		Queue<Integer> needtoQueue = new LinkedList<>();
		needtoQueue.add(0);
		int count = 1;
		int finish = n * m - 1;// 탈출하기위한 좌표.
		Queue<Integer> nextQueue = new LinkedList<>();
		outer: while (true) {
			while (!needtoQueue.isEmpty()) {
				int num = needtoQueue.poll();// 현재 방문한 정점
				int x = num / m;
				int y = num % m;
				visitSet.add(num); // 방문했음을 저장.
				// 현재 방문한 정점의 상하좌우를 순회하며 방문하지 않은경우 앞으로 방문해야하는 큐에 저장.
				for (int d = 0; d < 4; d++) {
					int adjx = x + dx[d]; // 인접 정점의 x좌표.
					int adjy = y + dy[d]; // 인접 정점의 y좌표.
					int adj = adjx * m + adjy; // 인접 정점의 숫자좌표.
					// 범위 벗어나거나 0이면 넘어감.
					if (adjx < 0 || adjy < 0 || adjx == n || adjy == m || arr[adjx][adjy] == 0) {
						continue;
					}
					if (!visitSet.contains(adj) && !needtovisitSet.contains(adj)) {
						needtovisitSet.add(adj);
						nextQueue.add(adj); // 다음 인접 정점들을 저장함.
					}
				}
			}
			count++;
			// 다음에 순회할 정점에 포함되어있으면 그만. 모든 정점 다 순회해도 그만.
			if (needtovisitSet.contains(finish) || nextQueue.size() == 0) {
				break outer;
			}
			needtoQueue = nextQueue; // 다음 순회할 정점들을 갱신. 트리로 따지면 다음 층.
			nextQueue = new LinkedList<>(); //
		}
		System.out.println(count);
	}
}
