package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지폭발 {
	static int R, C, T;
	static int[][] map;
	static int ac1R, ac1C, ac2R, ac2C;
	static List<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		newMap = new int[R][C];
		ac1R = -1;
		ac1C = -1;
		ac2R = -1;
		ac2C = -1;
		list = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0) {
					list.add(new int[] { i, j });
				} else if (map[i][j] == -1) {
					if (ac1R == -1) {
						ac1R = i;
						ac1C = j;
					} else {
						ac2R = i;
						ac2C = j;
					}
				}
			}
		}
		
		for(int t = 0 ; t < T ; t++) {
			spread();
			acControl();
		}
		
		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ans += map[i][j];
			}
		}
		ans += 2;
		System.out.println(ans);
	}

	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };
	static int[][] newMap;

	static void spread() {
		for(int i = 0 ; i < R ; i++) {
			newMap[i] = Arrays.copyOf(map[i], C);
		}
		
		// 계산하고 0이면 list에서 제거해야되는데 어디서 해야되냐고요
		int[] temp;
		int r, c, newR, newC, spreaded, spreadAmount;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			temp = list.get(i);
			r = temp[0];
			c = temp[1];
			spreaded = 0;
			spreadAmount = map[r][c] / 5;
			for (int d = 0; d < 4; d++) {
				newR = r + dr[d];
				newC = c + dc[d];
				if (newR >= 0 && newR < R && newC >= 0 && newC < C && map[newR][newC] != -1) {
					if (map[newR][newC] == 0) {
						list.add(new int[] { newR, newC });
					}
					newMap[newR][newC] += spreadAmount;
					spreaded++;
				}
			}
			newMap[r][c] -= (spreaded * spreadAmount);
		}
		map = newMap;
	}
	
	static int[] ac1dr = {0, -1, 0, 1, 0};
	static int[] ac1dc = {1, 0, -1, 0, 1};
	static int[] ac2dr = {0, 1, 0, -1, 0};
	static int[] ac2dc = {1, 0, -1, 0, 1};
	
	static void acControl() {
		int newR, newC, prevAir, currAir;
		newR = ac1R;
		newC = ac1C;
		prevAir = 0;
		
		circulate1:
		while(true){
			for(int d = 0 ; d < 5 ; d++) {
				while(true) {
					newR += ac1dr[d];
					newC += ac1dc[d];
					if(!(newR >= 0 && newR < R && newC >= 0 && newC < C)) {
						newR -= ac1dr[d];
						newC -= ac1dc[d];
						break;
					}
					if(map[newR][newC] == -1) {
						break circulate1;
					}
					currAir = map[newR][newC];
					map[newR][newC] = prevAir;
					prevAir = currAir;
				}
			}
		}
		
		newR = ac2R;
		newC = ac2C;
		prevAir = 0;
		
		circulate2:
		while(true){
			for(int d = 0 ; d < 5 ; d++) {
				while(true) {
					newR += ac2dr[d];
					newC += ac2dc[d];
					if(!(newR >= 0 && newR < R && newC >= 0 && newC < C)) {
						newR -= ac2dr[d];
						newC -= ac2dc[d];
						break;
					}
					if(map[newR][newC] == -1) {
						break circulate2;
					}
					currAir = map[newR][newC];
					map[newR][newC] = prevAir;
					prevAir = currAir;
				}
			}
		}
	}
}
