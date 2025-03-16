package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929_소수_구하기 {
	
	static boolean[] isNotPrime;
	static int N;

	private static void checkPrime() {
		
		isNotPrime[0] = isNotPrime[1] = true;
		for(int i=2; i*i<N+1; i++) {
			if(!isNotPrime[i]) {
				for(int j=i*i; j<N+1; j+=i) {
					isNotPrime[j] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		isNotPrime = new boolean[N+1];
		checkPrime();
		
		for(int i=M; i<=N; i++) {
			if(!isNotPrime[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}
}
