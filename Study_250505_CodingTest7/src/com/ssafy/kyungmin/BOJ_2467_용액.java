import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {
	public static void main(String[] args) throws Exception {
		// 산성 양 1~10억
		// 알칼리성 음 -1~-10억
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int l = 0;
		int r = N - 1;
		int closeAbsSum = Integer.MAX_VALUE;
		int[] res = new int[2];

		while (l < r) {
			int abs = Math.abs(arr[l] + arr[r]);

			if (abs < closeAbsSum) {
				closeAbsSum = abs;
				res[0] = arr[l];
				res[1] = arr[r];
			}

			if (arr[l] + arr[r] < 0) {
				l++;
			} else {
				r--;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(res[0]).append(" ").append(res[1]);
		System.out.println(sb);
	}
}
