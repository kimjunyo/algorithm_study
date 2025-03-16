package jungol.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JOL_2817_로또 {
	
	static int[] arr;
	static int[] num;
	private static void findCombination(int depth, int last) {
		
		if(depth ==6) {
			for(int n : num) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = last+1; i<arr.length; i++) {
			num[depth] = arr[i];
			findCombination(depth+1, i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		arr = new int[K];
		num = new int[6];
		
		int idx = 0;
		while(st.hasMoreTokens()) {
			arr[idx++] = Integer.parseInt(st.nextToken());
		}
		findCombination(0,-1);
	}
}
