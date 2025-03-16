package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_6603_로또 {
	
	static int[] arr;
	static int[] num;
	static StringBuilder sb;
	
	private static void findCombination(int depth, int last) {
	
		if(depth == 6) {
			for(int i=0; i<6; i++) {
				sb.append(num[i]).append(" ");
			}
			System.out.println(sb);
			sb.setLength(0);
			return;
		}
		
		
		for(int i=last+1; i<arr.length; i++) {
			num[depth] = arr[i];
			findCombination(depth+1, i);
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			//StringTokenizer st = new StringTokenizer(br.readLine());
//			int K = Integer.parseInt(st.nextToken());
			int K = sc.nextInt();
			if(K==0) return;
			
			arr = new int[K];
			
			for(int i=0; i<K; i++) {
//				arr[i] = Integer.parseInt(st.nextToken());
				arr[i] = sc.nextInt();
			}
			
			num = new int[6];
			sb = new StringBuilder();
			findCombination(0,-1);
			System.out.println();
		}
	}
}
