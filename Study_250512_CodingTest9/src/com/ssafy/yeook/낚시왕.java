package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 낚시왕 {
	static int R, C, sum, C1;// 격자판 행, 열 크기 (0번부터~), 잡은 물고기의 합, 열+1크기.
	static Node[][] arr; // 격자판
	static Set<Integer> set; // 살아있는 물고기들의 숫자좌표 저장.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		C1 = C + 1;
		int M = Integer.parseInt(st.nextToken());
		sum = 0;
		arr = new Node[R + 1][C1];
		set = new HashSet<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			arr[row][col] = new Node(speed, direction, size);
			set.add(row * C1 + col);
		} // 주어진 물고기들 저장.

		for (int kingIndex = 1; kingIndex <= C; kingIndex++) {
			if (set.size() == 0)
				break;
			catchFish(kingIndex);
			moveFishes();
		}
		System.out.println(sum);

	}// main

	static void moveFishes() {
		Node[][] nextArr = new Node[R + 1][C1];
		Set<Integer> nextSet = new HashSet<>();
		for (int rc : set) {
			int row = rc / C1;
			int col = rc % C1;
			Node node = arr[row][col];
			int speed = node.speed;
			int d = node.direction;

			// 행이나 열이 1이면 움직일 필요없음.
			if (!(((d == 1 || d == 2) && R == 1) || ((d == 3 || d == 4) && C == 1))) {
				while (speed > 0) {
					// 방향 = 위
					if (d == 1) {
						if (row == 1) {
							d = 2;
							row++;
						} else
							row--;

						// 방향 = 아래
					} else if (d == 2) {
						if (row == R) {
							d = 1;
							row--;
						} else
							row++;

						// 방향 = 오른쪽
					} else if (d == 3) {
						if (col == C) {
							d = 4;
							col--;
						} else
							col++;
						// 방향 = 왼쪽
					} else if (d == 4) {
						if (col == 1) {
							d = 3;
							col++;
						} else
							col--;
					}

					speed--;
				} // while
			} // if

			node.direction = d;
			if (nextArr[row][col] == null) {
				nextArr[row][col] = node;
				nextSet.add(row * C1 + col);
			} else {
				if (nextArr[row][col].size < node.size) {
					nextArr[row][col] = node;
				}
			}

		} // 물고기들 이동시키기.
		arr = nextArr;
		set = nextSet;
	}

	// 물고기 잡기
	static void catchFish(int kingIndex) {
		for (int row = 1; row <= R; row++) {
			if (arr[row][kingIndex] != null) {
				Node node = arr[row][kingIndex];
				sum += node.size;
				set.remove(row * C1 + kingIndex);
				arr[row][kingIndex] = null;
				break;
			}
		}
	};

	static class Node {
		int speed, direction, size; // 속력, 방향, 크기.

		public Node(int speed, int direction, int size) {
			this.speed = speed;
			this.direction = direction;
			this.size = size;
		}
	}

}
