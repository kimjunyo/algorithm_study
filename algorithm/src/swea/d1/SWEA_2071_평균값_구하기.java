package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2071_평균값_구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int sum =0;
			while(st.hasMoreTokens()) {
				sum += Integer.parseInt(st.nextToken());
			}
			sb.append("#"+tc+" ").append((int)(Math.round(sum/10.0)));
			System.out.println(sb);
			sb.setLength(0);
		}
	}

}
