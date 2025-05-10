package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕 {
	static class Shark {
		int r;
		int c;
		int speed;
		int dir;
		int size;
		boolean dead;
	}

	static int R;
	static int C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[R][C];
		Shark[] sharks = new Shark[M + 1];
		int shallow = R;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			Shark s = new Shark();
			s.r = Integer.parseInt(st.nextToken()) - 1;
			s.c = Integer.parseInt(st.nextToken()) - 1;
			s.speed = Integer.parseInt(st.nextToken());
			s.dir = Integer.parseInt(st.nextToken());
			s.size = Integer.parseInt(st.nextToken());
			s.dead = false;
			sharks[i] = s;
			map[s.r][s.c] = i;
			
			// c = 0 인 상어들의 r 값 비교해서 shallow에 저장
			if(s.c == 0 && s.r < shallow) {
				shallow = s.r;
			}
		}

		int ans = 0;
		Shark shark, anotherShark;
		for (int i = 0; i < C; i++) {
			
			// shallow의 상어 값이 있으면 어부가 잡고 죽은걸로, 맵에서도 삭제 후 넘어감
			if (shallow != R) {
				shark = sharks[map[shallow][i]];
				shark.dead = true;
				ans += shark.size;
				map[shark.r][shark.c] = 0;
			}

			// 맵, shallow 초기화
			map = new int[R][C];
			shallow = R;
			for (int s = 1; s <= M; s++) {
				shark = sharks[s];
				// 죽은 상어면 넘어간다
				if(shark.dead) {
					continue;
				}
				
				// 상어 위치 변경
				move(shark);
				
				// 상어가 이미 있다
				if(map[shark.r][shark.c] != 0) {
					anotherShark = sharks[map[shark.r][shark.c]];
					if(anotherShark.size > shark.size) {
						// 원래 상어가 크면 지금 상어는 죽은걸로 하고 넘어감
						shark.dead = true;
						continue;
					}else {
						// 지금 상어가 크면 원래 상어는 죽음
						anotherShark.dead = true;
					}
				}
				
				// 지금 상어가 살아남았으면 맵에 등록
				map[shark.r][shark.c] = s;
				
				// c = i + 1 이면 r 값 비교해서 shallow에 저장
				if(shark.c == i + 1 && shark.r < shallow) {
					shallow = shark.r;
				}
			}
		}
		
		System.out.println(ans);
	}

	static void move(Shark shark) {
		int r = shark.r;
		int c = shark.c;
		int speed = shark.speed;
		int dir = shark.dir;
		
		if (dir == 1 || dir == 2) {
			if (dir == 1) {
				r -= speed;
			} else {
				r += speed;
			}
			while(r < 0 || r >= R) {
				if (r < 0) {
					r *= -1;
				}else {
					r = (R - 1) - (r - (R - 1));
				}
				dir++;
			}
			dir %= 2;
			if(dir == 0) {
				dir = 2;
			}
			shark.r = r;
			shark.dir = dir;
		}
		
		if (dir == 3 || dir == 4) {
			if (dir == 4) {
				c -= speed;
			} else {
				c += speed;
			}
			while(c < 0 || c >= C) {
				if (c < 0) {
					c *= -1;
				}else {
					c = (C - 1) - (c - (C - 1));
				}
				dir++;
			}
			dir %= 2;
			if(dir == 0) {
				dir = 4;
			}else {
				dir = 3;
			}
			shark.c = c;
			shark.dir = dir;
		}
	}
}
