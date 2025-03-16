package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_7087_문제_제목_붙이기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
		sb.append("#"+tc+" ");
			
			int N = Integer.parseInt(br.readLine());
			boolean[] alphabets = new boolean[26];
			for(int i=1; i<=N; i++) {
				String check = br.readLine();
				alphabets[check.charAt(0)-'A'] = true;
			}
			int cnt = 0;
			for(int i=0; i<alphabets.length; i++) {
				if(alphabets[i]) cnt++;
				else break;
			}
			
			sb.append(cnt);
			System.out.println(sb);
			sb.setLength(0);
		}
		
		
		
		
		
	}

}
