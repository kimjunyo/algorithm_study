package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912_연속합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = Integer.parseInt(st.nextToken());
		int max = sum;
		
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			sum = Math.max(sum + num, num);
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
