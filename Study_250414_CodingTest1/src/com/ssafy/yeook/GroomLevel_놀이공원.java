package com.ssafy.yeook;

import java.io.*;
import java.util.*;
class 놀이공원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cases = Integer.parseInt(st.nextToken());
		for(int t = 1;t<=cases; t++){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int [][] park = new int[n+1][n+1];
			for(int i = 0;i<n;i++){
				st = new StringTokenizer(br.readLine());
				for(int j = 0;j<n;j++){
					park[i+1][j+1] = Integer.parseInt(st.nextToken());
				}
			}// 주어진 입력 저장.

			int [][] sum = new int [n+1][n+1]; // 0,0 좌표 부터 x,y까지 폐기물의 갯수 누적합 저장.
			for(int i = 1;i<=n;i++){
				for(int j = 1;j<=n;j++){
					sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1];
					if(park[i][j]==1){
						sum[i][j]++;
					}
				}
			}// 누적합 저장.

			int answer = Integer.MAX_VALUE;

			int [][] result = new int[n+1][n+1]; // 해당 좌표가 k*k의 우측하단 좌표일때 쓰레기의 갯수.

			for(int i = k;i<=n;i++){
				for(int j = k;j<=n;j++){
					int count = sum[i][j]-sum[i-k][j]-sum[i][j-k]+sum[i-k][j-k];
					answer = Math.min(answer,count);
				}
			}
			System.out.println(answer);
		}
		
		

	}
}