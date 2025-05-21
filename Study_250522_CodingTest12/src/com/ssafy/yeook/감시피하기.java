package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * 장애물 필요한 행, 열 저장 
 * 
 * */

public class 감시피하기 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static ArrayList<int[]> students;
	static ArrayList<int[]> teachers;
	static char[][] arr;
	static int n, nn;
	static boolean[][] must;
	static int[] select;
	static ArrayList<Integer> list;
	static boolean isStop;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new char[n][n];
		must = new boolean[n][n];
		isStop = false;
		list = new ArrayList<>();
		students = new ArrayList<>();
		teachers = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = st.nextToken().charAt(0);
				if (arr[i][j] == 'S')
					students.add(new int[] { i, j });
				else if (arr[i][j] == 'T')
					teachers.add(new int[] { i, j });
				else
					list.add(i * n + j);

			}
		} // 주어진 배열 저장

		select = new int[3];

		if (!isOk()) {
			System.out.println("NO");
			return;
		}

		comb(0, 0);
		if (isStop)
			System.out.println("YES");
		else
			System.out.println("NO");

	}// main

	// 선생 바로 인접에 학생있는지
	static boolean isOk() {
		for (int[] teacher : teachers) {
			int x = teacher[0];
			int y = teacher[1];
			for (int d = 0; d < 4; d++) {
				int adjx = x + dx[d];
				int adjy = y + dy[d];
				if (adjx >= 0 && adjy >= 0 && adjx < n && adjy < n && arr[adjx][adjy] == 'S')
					return false;
			}
		}
		return true;
	}

	static void comb(int index, int selectedIndex) {
		if (isStop)
			return;
		boolean isYes = true;
		if (selectedIndex == select.length) {

			for (int xy : select) {
				int x = xy / n;
				int y = xy % n;
				arr[x][y] = 'O';

			}

			outer: for (int[] teacher : teachers) {
				int x = teacher[0];
				int y = teacher[1];
				for (int d = 0; d < 4; d++) {
					for (int k = 1; k < n; k++) {
						int adjx = x + dx[d] * k;
						int adjy = y + dy[d] * k;

						if (adjx >= 0 && adjy >= 0 && adjx < n && adjy < n) {
							if (arr[adjx][adjy] == 'S') {
								isYes = false;
								break outer;
							} else if (arr[adjx][adjy] == 'O')
								break;
						} else
							break;

					}
				}
			}
			if (isYes) {
				isStop = true;
				return;
			}

			for (int xy : select) {
				int x = xy / n;
				int y = xy % n;
				arr[x][y] = 'X';

			}

			return;
		} // 가능여부 검사

		if (index >= list.size())
			return;

		select[selectedIndex] = list.get(index);
		comb(index + 1, selectedIndex + 1);// 선택한경우.
		comb(index + 1, selectedIndex);// 선택안한경우.
	}

}
