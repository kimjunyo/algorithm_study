package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2817_부분_수열의_합 {
	static int K;
	static int[] arr;
	static int[] num;
	static int cnt;
	
	private static void combination(int depth, int last) {
		
		if(depth == num.length) {
			int check = 0;
			for(int i=0; i<num.length; i++) {
				check += num[i];
			}
			if(check == K) cnt++;
			return;
		}
		
		for(int i= last+1; i<arr.length; i++) {
			num[depth] = arr[i];
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
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			cnt = 0;
			for(int i=0; i<N; i++) {
				num = new int[i+1];
				combination(0,-1);
			}
			
			System.out.println(sb.append(cnt));
			sb.setLength(0);
		}
	}
}
