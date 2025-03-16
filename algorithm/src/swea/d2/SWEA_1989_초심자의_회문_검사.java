package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1989_초심자의_회문_검사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=T; tc++) {
			String input = br.readLine();
			boolean check = true;
			for(int i=0; i<input.length()/2; i++) {
				if(input.charAt(i) != input.charAt(input.length()-1-i)) {
					check = false;
					break;
				}
			}
			if(!check) {
				System.out.println("#"+tc+" "+"0");
			}else {
				System.out.println("#"+tc+" "+"1");
			}
		}
	}
}
