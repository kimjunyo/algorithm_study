package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1213_String {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc =1; tc<=10; tc++) {
			int T = Integer.parseInt(br.readLine());
			String target = br.readLine();
			String input = br.readLine();
			
			int idx = input.indexOf(target);
			int cnt =0;
			if(idx == -1) {
				System.out.println("#"+tc+" "+0);
			}else {
				cnt = 0;
				while(idx != -1) {
					idx = input.indexOf(target, idx+1);
					cnt++;
				}
				System.out.println("#"+tc+" "+cnt);
			}
		}
		
	}

}
