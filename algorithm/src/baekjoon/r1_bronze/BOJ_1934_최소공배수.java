package baekjoon.r1_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1934_최소공배수 {
	
	static int result;
	
	private static void findMultiple(int A, int B) {
		int R = A%B;
		
		if(R ==0) {
			result = B;
			return;
		}
		findMultiple(B,R);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			result =0;
			findMultiple(A,B);
			sb.append(A*B/result).append("\n");
		}
		System.out.println(sb);
	}
}
