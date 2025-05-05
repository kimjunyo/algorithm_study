package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 미생물연구 {
	static int n, q;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder result = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());// 배양 크기
		q = Integer.parseInt(st.nextToken()); // 배양 횟수
		arr = new int[n][n]; // 몇번째 미생물인지 저장.

		for (int order = 1; order <= q; order++) { // order 몇번째 미생물
			st = new StringTokenizer(br.readLine());
			int startcol = Integer.parseInt(st.nextToken());
			int startrow = Integer.parseInt(st.nextToken());
			int endcol = Integer.parseInt(st.nextToken());
			int endrow = Integer.parseInt(st.nextToken());
			int total = (endcol - startcol) * (endrow - startrow); // 새로투입되는 미생물의 수.

			input(order, startrow, startcol, endrow, endcol); // 미생물 투입.
//			print();

			int[] groupCount = new int[q + 1]; // 같은 미생물이 몇등분인지.
			Group[] groups = new Group[q + 1];
			visit = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] > 0 && !visit[i][j]) {
						int curOrder = arr[i][j];
						if (groupCount[curOrder] == 0) {
							groups[curOrder] = bfs(curOrder, i, j);
						}
						groupCount[curOrder]++;
					} // 미생물이 있다면
				}
			} // 몇등분 조사.

			// 1개의 그룹만 존재하면 priorityQueue에 넣기.
			PriorityQueue<Group> groupsSort = new PriorityQueue<>();
			for (int i = 1; i <= order; i++) {
				if (groupCount[i] == 1)
					groupsSort.add(groups[i]);
			}

			// 남은 미생물 새로운 배양용기에 옮기기.
			int[][] nextArr = new int[n][n]; // 새 배양용기.
			while (!groupsSort.isEmpty()) {
				Group group = groupsSort.poll();
				int x = group.x;
				int y = group.y;
				int curOrder = group.order;
				int difx = 0;
				int dify = 0;
				boolean isOk = true;
				outer: for (int col = 0; col < n; col++) {
					for (int row = 0; row < n; row++) {
						isOk = true;
						difx = row - x; // 옮길 위치와 현재 위치의 x차이.
						dify = col - y; // 옮길 위치와 현재 위치의 y차이.

						for (int xy : group.coords) {
							int curx = xy / n;
							int cury = xy % n;
							int movex = curx + difx;
							int movey = cury + dify;
//							System.out.println(movex + " " + movey);
							if (movex < 0 || movey < 0 || movex >= n || movey >= n || nextArr[movex][movey] != 0) {
								isOk = false;
								break;
							}
						}
						if (isOk)
							break outer;
					}
				} // 옮길수 있는지 확인.

				// 옮길수 있으면 옮기기.
				if (isOk) {
					for (int xy : group.coords) {
						int curx = xy / n;
						int cury = xy % n;
						int movex = curx + difx;
						int movey = cury + dify;
						nextArr[movex][movey] = curOrder;
					}
				}
			} // while.

			arr = nextArr;
//			print(nextArr);

			// 인접 확인하기.
			result.append(isAttach(order, groups)).append("\n");

		} // Q번째실험.
		bw.write(result.toString().trim());
		bw.flush();

	}// main

	// 미생물 투입하기
	static void input(int order, int startrow, int startcol, int endrow, int endcol) {
		for (int row = startrow; row < endrow; row++) {
			for (int col = startcol; col < endcol; col++) {
				arr[row][col] = order;
			}
		}
	}// 미생물 투입 종료.

	// 그룹 찾기
	static Group bfs(int order, int startx, int starty) {
		Group group = new Group(startx, starty, order);
		int total = 1;
		Queue<int[]> needtovisit = new ArrayDeque<>();
		needtovisit.add(new int[] { startx, starty });
		visit[startx][starty] = true;
		group.coords.add(startx * n + starty);

		while (!needtovisit.isEmpty()) {
			int[] deque = needtovisit.poll();
			int x = deque[0];
			int y = deque[1];
			for (int d = 0; d < 4; d++) {
				int adjx = x + dx[d];
				int adjy = y + dy[d];
				if (adjx >= 0 && adjy >= 0 && adjx < n && adjy < n && !visit[adjx][adjy] && arr[adjx][adjy] == order) {
					total++;
					needtovisit.add(new int[] { adjx, adjy });
					visit[adjx][adjy] = true;
					group.coords.add(adjx * n + adjy);

				}
			}
		}
		group.total = total;
		return group;
	}

	// 인접 확인.
	static int isAttach(int curq, Group[] groups) {
		int total = 0;
		boolean[][] attach = new boolean[curq + 1][curq + 1];
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				if (arr[x][y] > 0) {
					for (int d = 0; d < 4; d++) {
						int adjx = x + dx[d];
						int adjy = y + dy[d];
						if (adjx >= 0 && adjy >= 0 && adjx < n && adjy < n && arr[x][y] != arr[adjx][adjy]
								&& !attach[arr[x][y]][arr[adjx][adjy]]) {
							attach[arr[x][y]][arr[adjx][adjy]] = true;
							attach[arr[adjx][adjy]][arr[x][y]] = true;
						}
					}
				}

			}
		}
		for (int i = 1; i <= curq - 1; i++) {
			for (int j = i + 1; j <= curq; j++) {
				if (attach[i][j]) {
					total += groups[i].total * groups[j].total;
				}
			}
		}
		return total;
	}

	static void print(int[][] arr) {
		System.out.println("--------------");
		for (int x = n - 1; x >= 0; x--) {
			for (int y = 0; y < n; y++) {
				System.out.print(arr[x][y] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------");
	}

	static class Group implements Comparable<Group> {
		int x, y; // 해당 그룹을 나타내는 대표xy좌표.
		int order; // 해당 그룹의 번호
		int total = 1; // 해당그룹의 미생물 수
		Set<Integer> coords = new HashSet<>(); // 해당 그룹 미생물들의 좌표.

		public Group(int x, int y, int order) {
			this.x = x;
			this.y = y;
			this.order = order;

		}

		@Override
		public int compareTo(Group o) {
			if (this.total == o.total)
				return this.order - o.order;
			return o.total - this.total;
		}

	}

}
