import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//	31580	344
public class BOJ_4485_녹색옷을입은애가젤다지 {
	static int[][] arr;
	static int[][] dist;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Node {
		int[] coor;
		int k;

		public Node(int[] coor, int k) {
			this.coor = coor;
			this.k = k;
		}

		@Override
		public String toString() {
			return "노드 [coor=" + Arrays.toString(coor) + ", k=" + k + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = 1;
		while (true) {
			// 2~125
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			// 원소는 0~9
			arr = new int[N][N];
			dist = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}

			PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.k, b.k));

			pq.offer(new Node(new int[] { 0, 0 }, arr[0][0]));
			dist[0][0] = arr[0][0];

			while (!pq.isEmpty()) {
				Node curr = pq.poll();

				int cr = curr.coor[0];
				int cc = curr.coor[1];
				dist[cr][cc] = curr.k;

				if (cr == N - 1 && cc == N - 1) {
					break;
				}

				for (int i = 0; i < delta.length; i++) {
					int nr = cr + delta[i][0];
					int nc = cc + delta[i][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N && dist[nr][nc] > curr.k + arr[nr][nc]) {
						Node n = new Node(new int[] { nr, nc }, curr.k + arr[nr][nc]);
						pq.offer(n);
					}
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("Problem ");
			sb.append(tc++);
			sb.append(": ");
			sb.append(dist[N - 1][N - 1]);
			System.out.println(sb);
		}
	}
}
