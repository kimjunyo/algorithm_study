class Solution {
	static final int INF = Integer.MAX_VALUE;

	public int solution(int n, int s, int a, int b, int[][] fares) {
		int[][] dist = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == j) {
					dist[i][j] = 0;
					continue;
				}
				dist[i][j] = INF;
			}
		} // 거리 배열 무한대로 설정. 자기자신은 0

		for (int i = 0; i < fares.length; i++) {
			int aa = fares[i][0];
			int bb = fares[i][1];
			int w = fares[i][2];// 요금.
			dist[aa][bb] = w;
			dist[bb][aa] = w;
		} // 주어진 배열 저장.

		// 플로이드워셜
		for (int k = 1; k <= n; k++) {// 경유지.
			for (int start = 1; start <= n; start++) { // 출발지
				if (k == start)
					continue;
				for (int end = 1; end <= n; end++) { // 목적지
					if (k == end)
						continue;
					if (dist[start][k] != INF && dist[k][end] != INF
							&& dist[start][end] > dist[start][k] + dist[k][end]) {
						dist[start][end] = dist[start][k] + dist[k][end];
					}

				}
			}
		} // 모든 정점에서 각 정점까지 경유했을때의 최단 거리 저장.

		int min = INF;
		for (int k = 1; k <= n; k++) {
			min = Math.min(min, dist[s][k] + dist[k][a] + dist[k][b]);
		}

		return min;
	}
}