package twopointer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 10 ~ 100,000
		int N = Integer.parseInt(st.nextToken());
		// 0 ~ 100,000,000
		int S = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		// 연속된 수들의 부분합
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int min = Integer.MAX_VALUE;
		int INF = min;
		int sum = 0;
		int start = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];

			while (sum >= S) {
				min = Math.min(min, i - start + 1);
				sum -= arr[start++];
			}

		}

		if (min == INF) {
			System.out.println(0);
		} else {
			System.out.println(min);
		}
	}
}
