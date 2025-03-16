package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//시간초과 떴음
public class BOJ_11047_동전0 {

	static Integer[] arr;
	static int[] num;
	static int K;

	private static boolean check(int depth, int start, int cnt) {
		int sum = 0;

		if (depth == cnt) {
			
			for (int m : num) {
				sum += m;
			}
			if (sum == K) {
				//System.out.println(Arrays.toString(num));
				return true;
			}
				
			else return false;
		}

		for (int i = start; i < arr.length; i++) {
			
			if(sum+arr[i]>K) continue;
			
			num[depth] = arr[i];
			if (check(depth + 1, i, cnt)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new Integer[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] == K) {
				System.out.println(1);
				return;
			}
		}

		Arrays.sort(arr, Collections.reverseOrder());

		for (int cnt = 2; cnt <= K; cnt++) {
			num = new int[cnt]; 
			if (check(0, 0, cnt)) { 
				System.out.println(cnt);
				return;
			}
		}
	}
}