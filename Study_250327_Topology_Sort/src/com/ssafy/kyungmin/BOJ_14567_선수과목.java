package topology.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14567_선수과목 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 1~1000
		// 과목 수
		int N = Integer.parseInt(st.nextToken());
		List<Integer>[] arr = new ArrayList[N + 1];
		int[] res = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		// 0~500000
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[b].add(a);
		}
//		System.out.println(Arrays.toString(q));

		int cnt = 0;
		while (cnt < N) {
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < arr[i].size(); j++) {
					res[i] = Math.max(res[arr[i].get(j)], res[i]);
				}

				res[i]++;
				cnt++;
			}
		}
//		System.out.println(Arrays.toString(res));

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N; i++) {
			sb.append(res[i]).append(" ");
		}
		sb.append(res[N]);
		System.out.println(sb);
	}
}
