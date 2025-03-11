package com.ssafy.junyoung.암호만들기_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] alphabet, res;
	static int N, moCount, jaCount;

	public static void main(String[] args) throws IOException {
		initArray();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		int C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < C; i++) {
			alphabet[st.nextToken().toCharArray()[0] - 'a'] = 1;
		}

		comb(0, 0);
	}

	private static void comb(int idx, int sidx) {
		if (sidx == N) {
			if (moCount >= 1 && jaCount >= 2) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 26; i++) {
					if(res[i] == 1) {
						sb.append(String.valueOf((char) ('a'+i)));
					}
				}
				System.out.println(sb);
			}
		} else if (idx == 26) {
			return;
		} else {
			if (alphabet[idx] == 1) {
				switch (idx) {
				case 0:
				case 4:
				case 8:
				case 14:
				case 20:
					moCount++;
					res[idx] = 1;
					comb(idx + 1, sidx + 1);
					res[idx] = 0;
					moCount--;
					break;
				default:
					jaCount++;
					res[idx] = 1;
					comb(idx + 1, sidx + 1);
					res[idx] = 0;
					jaCount--;
					break;
				}
			}
			comb(idx + 1, sidx);
		}
	}

	private static void initArray() {
		alphabet = new int[26];
		res = new int[26];
	}
}
