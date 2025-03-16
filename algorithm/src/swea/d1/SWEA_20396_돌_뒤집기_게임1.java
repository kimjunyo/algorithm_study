package swea.d1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_20396_돌_뒤집기_게임1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc =1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] rock = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				rock[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st.nextToken())-1;
				int q = Integer.parseInt(st.nextToken())-1;
				
				int change = 0;
				if(rock[p]==1) change = 1;
				
				while(q>0) {
					int idx = p+q;
					if(idx<N) {
						rock[idx] = change;
					}
					q--;
				}
			}
			
			for(int i=0; i<N; i++) {
				sb.append(rock[i]).append(" ");
			}
			
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}