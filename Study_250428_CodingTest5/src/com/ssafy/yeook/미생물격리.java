package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미생물격리 {
	static int N, M, K;
	static boolean isStop;
	static Node[][] arr, arr2;
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cases = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= cases; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new Node[N][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				arr[x][y] = new Node(x, y, count, direction, count);
			} // 주어진 미생물 저장.

			for (int m = 1; m <= M; m++) {
				isStop = true;
				arr2 = new Node[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (arr[i][j] != null) {
							Node node = move(i, j, arr[i][j].count, arr[i][j].d);
							if (node != null) {
								isStop = false;
								int x = node.x;
								int y = node.y;
								if (arr2[x][y] != null) {
									if (arr2[x][y].preCount < node.preCount) {
										arr2[x][y].d = node.d;
										arr2[x][y].preCount = node.preCount;
									}
									arr2[x][y].count += node.count;
								} else
									arr2[x][y] = node;
							}
						}
					}
				}

				arr = arr2;
				if (isStop)
					break;
			} // m시간
			if (isStop) {
				System.out.println("#" + t + " " + 0);
				continue;
			}
			int total = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] != null) {
						total += arr[i][j].count;
					}
				}
			}
			System.out.println("#" + t + " " + total);

		} // tc
	}// main

	static Node move(int x, int y, int count, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		if (nx == 0 || ny == 0 || nx == N - 1 || ny == N - 1) {
			d = reverse(d);
			count /= 2;
			if (count == 0)
				return null;
			else
				return new Node(nx, ny, count, d, count);
		} else {
			return new Node(nx, ny, count, d, count);
		}
	}

	static int reverse(int d) {
		if (d == 1)
			return 2;
		if (d == 2)
			return 1;
		if (d == 3)
			return 4;
		if (d == 4)
			return 3;
		return -1;
	}

	static class Node {
		int x, y, count, d, preCount; // preCount = 동시에 여러곳에서 오는 경우 이전 합친값으로 비교하면 안됨.

		public Node(int x, int y, int count, int d, int preCount) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.d = d;
			this.preCount = preCount;
		}

	}

}
