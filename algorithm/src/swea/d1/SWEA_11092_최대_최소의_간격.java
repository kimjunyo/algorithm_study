package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_11092_최대_최소의_간격 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int maxIdx = 0; int minIdx = 0; int max =0; int min =11;
			for(int i=1; i<=N; i++) {
				int input = Integer.parseInt(st.nextToken());
				if(input>=max) {
					max = input;
					maxIdx = i;
				}
				if(min>input) {
					min = input;
					minIdx =i;
				}
			}
			System.out.println("#" + tc + " " + Math.abs(maxIdx - minIdx));
		}
	}

}
