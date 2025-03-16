package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9367_점점_커지는_당근의_개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 1, maxCnt = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			for(int i=1; i<N; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(num>check) cnt++;
				else cnt = 1;

				check = num;
				maxCnt = Math.max(maxCnt,cnt);
			}
			System.out.println("#" + tc + " " + maxCnt);
		}
	}
}