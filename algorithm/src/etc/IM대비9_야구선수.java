package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IM대비9_야구선수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int maxCnt = 0;
			for(int start=0; start<N; start++) {
				int p =0, cnt = 1;
				while(true) {
					if((start+(++p))<N && arr[start+p]-arr[start] <= L) {
						cnt++;
					}
					else break;
				}
				maxCnt = Math.max(maxCnt, cnt);
			}
			System.out.println(sb.append(maxCnt));
			sb.setLength(0);
		}
	}
}