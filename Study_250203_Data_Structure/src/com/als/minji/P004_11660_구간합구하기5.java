package com.als.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P004_11660_구간합구하기5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] nums = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][]sums = new int[N + 1][N + 1];
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				sums[i][j] = sums[i][j-1] + sums[i-1][j] - sums[i - 1][j - 1] + nums[i][j];
			}
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			System.out.println(sums[x2][y2] - sums[x1][y2] - sums[x2][y1] + sums[x1][y1]);
		}
	}
}