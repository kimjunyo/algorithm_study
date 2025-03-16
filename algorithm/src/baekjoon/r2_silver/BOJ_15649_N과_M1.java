package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_N과_M1 {
	static int[] arr;
	static int[] num;
	static int M;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	
	private static void findPermutation(int depth) {
		if(depth == M ) {
			for(int i=0; i<M; i++) {
				sb.append(num[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!visit[i]) {
				visit[i] = true;
				num[depth]= arr[i];
				findPermutation(depth+1);
				visit[i] = false;
			}
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		num = new int[M];
		visit = new boolean[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		findPermutation(0);
		System.out.println(sb);
	}
}
