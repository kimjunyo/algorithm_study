package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1959_두_개의_숫자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] A = new int[N];
			int[] B = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) 
				A[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) 
				B[i] = Integer.parseInt(st.nextToken());
			
			int result = 0;
			int idx =0;
			if(N>M) { //B이 짧은 배열
				for(int i=0; i<N-M+1; i++) {
					idx = 0; int cal = 0;
					while(idx<M) cal += A[i+idx]*B[idx++];
					result = Math.max(result, cal);
				}
			}else { //A가 짧은배열
				for(int i=0; i<M-N+1; i++) {
					idx = 0; int cal = 0;
					while(idx<N) cal += B[i+idx]*A[idx++];
					result = Math.max(result, cal);
				}
			}
			System.out.println("#"+tc+" "+result);
		}
	}
}