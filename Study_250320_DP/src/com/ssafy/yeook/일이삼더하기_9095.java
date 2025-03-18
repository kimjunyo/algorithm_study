package dd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 일이삼더하기_9095 {
	public static int count;
	public static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder result = new StringBuilder();
		int cases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		for (int t = 1; t <= cases; t++) {
			n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			count = 0;
			perm(0);
			result.append(count).append("\n");
		} // tc
		bw.write(result.toString().trim());
		bw.flush();
	}// main

	public static void perm(int sum) {
		if (sum == n) {
			count++;
		}
		if (sum > n) {
			return;
		}
		for (int i = 1; i <= 3; i++) {
			perm(sum + i);
		}
	}// perm
}