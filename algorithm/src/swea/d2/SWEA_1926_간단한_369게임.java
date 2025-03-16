package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1926_간단한_369게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			char[] num = String.valueOf(i).toCharArray();
			int cnt =0;
			for(char c : num) {
				if(c=='3' || c=='6' || c=='9') cnt++;
			}
			//if(cnt!=0) System.out.print("-".repeat(cnt));
			if(cnt!=0) {
				for(int j=0; j<cnt; j++) {
					System.out.print("-");
				}
			}
			else System.out.print(i);
			System.out.print(" ");
		}
	}
}