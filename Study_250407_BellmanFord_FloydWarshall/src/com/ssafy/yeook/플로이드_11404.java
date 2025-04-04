package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 플로이드_11404 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());// 1~n
		int m = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());// 버스갯수.
		StringTokenizer st;
		int[][] dist = new int[n + 1][n + 1]; // a -> b까지의 최단거리 저장.
		for (int i = 1; i <= n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			dist[i][i] = 0;
		} // 자기자신은 0, 나머지 무한대로 초기화.

		// 주어진 간선 저장.
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			dist[a][b] = Math.min(w, dist[a][b]); // 똑같이a->b로가는 버스가 비용이 다른경우가 있음.

		}

		// 모든 도시를 각각 경유하는 경우.
		for (int k = 1; k <= n; k++) {// 경유지.
			for (int start = 1; start <= n; start++) {
				if (start == k) // 시작과 경유지가 같은건 굳이 할필요없음.
					continue;
				for (int end = 1; end <= n; end++) {
					if (end == k)
						continue;
					if (dist[start][k] != Integer.MAX_VALUE && dist[k][end] != Integer.MAX_VALUE
							&& dist[start][end] > dist[start][k] + dist[k][end]) {
						dist[start][end] = dist[start][k] + dist[k][end];
					}
				}
			}
		} // 플로이드 워셜.

		// 자기 자신으로 가는 비용이 음수라면 음의 사이클이 있다는 의미.
		boolean isOk = true;
		for (int i = 1; i <= n; i++) {
			if (dist[i][i] < 0) {
				isOk = false;
				break;
			}
		}
		for (int i = 1; i <= n; i++) {
			StringBuilder result = new StringBuilder();
			for (int j = 1; j <= n; j++) {
				if (dist[i][j] == Integer.MAX_VALUE) {
					result.append(0 + " ");
				} else
					result.append(dist[i][j] + " ");
			}
			System.out.println(result.toString().trim());
		}

	}

}
