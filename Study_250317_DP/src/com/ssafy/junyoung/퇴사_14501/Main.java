package 퇴사;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] T, P, res;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		T = new int[N + 1];
		P = new int[N + 1];
		res = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			dp(i, i, 0, 0);
		}
		
		int max = -1;
		for (int i=1; i<=N; i++) {
			max = Integer.max(max, res[i]);
		}
		
		System.out.println(max);
	}
	
	private static void dp(int i, int process, int sum, int beforeProfit) {
		if(process == N + 1) {
			if(res[i] < sum) {
				res[i] = sum;
			}
			return;
		}
		
		if(process > N+1) {
			sum -= beforeProfit;
			
			if(res[i] < sum) {
				res[i] = sum;
			}
			return;
		}
		
		for(int j=process; j<=N; j++) {
			dp(i, j+T[j], sum+P[j], P[j]);
		}
	}
}
