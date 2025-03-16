package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5215_햄버거_다이어트 {
	
	static int[] arr;
	static int L;
	static int[] score;
	static int[] cal;
	static int maxScore;
	
	private static void combination(int depth, int last) {
		
		if(depth == arr.length) {
			int sumCalorie = 0;
			int sumScore = 0;
			for(int i=0; i<arr.length; i++) {
				sumScore += score[arr[i]];
				sumCalorie+= cal[arr[i]];
			}
			
			if(sumCalorie<=L) {
				maxScore = Math.max(maxScore, sumScore);
			}
			return;
		}
		
		for(int i= last+1; i<cal.length; i++) {
			arr[depth] = i;
			combination(depth+1, i);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#" + tc + " ");
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			score = new int[N];
			cal = new int[N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			maxScore = 0;
			for(int i=1; i<=N; i++) {
				arr = new int[i];
				combination(0,-1);
			}
			
			sb.append(maxScore);
			System.out.println(sb);
			sb.setLength(0);
		}
	}

}
