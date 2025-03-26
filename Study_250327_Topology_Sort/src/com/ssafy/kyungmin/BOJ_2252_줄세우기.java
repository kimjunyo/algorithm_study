package topology.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_줄세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 1~32000
		// 과목 수
		int N = Integer.parseInt(st.nextToken());
		List<Integer>[] arr = new ArrayList[N + 1];
		int[] inDegree = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		// 0~100000
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			inDegree[b]++;
		}

//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(inDegree));

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr).append(" ");

			for (Integer n : arr[curr]) {

				inDegree[n]--;
				if (inDegree[n] == 0) {
					q.offer(n);
				}
			}
		}

//		System.out.println(Arrays.toString(res));
		System.out.println(sb.toString().trim());
	}
}
