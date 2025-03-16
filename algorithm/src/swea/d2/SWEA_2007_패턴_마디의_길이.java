package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2007_패턴_마디의_길이 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			char check = input.charAt(0);  
			int idx = 0; int idx2 = -1; int result = 0;
			while (true) {
				
				idx2 = input.indexOf(check, idx + 1);
				
				if (idx2 == -1) break;

				int length = idx2; // 패턴 길이
				if (idx2 + length <= input.length() && input.substring(0, idx2).equals(input.substring(idx2, idx2 + length))) {  
					result = idx2;
					break;  
				}
				idx = idx2;
			}
			sb.append("#"+tc+" "+result);
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
