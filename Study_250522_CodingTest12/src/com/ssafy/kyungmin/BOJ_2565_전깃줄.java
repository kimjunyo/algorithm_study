import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int from;
	int to;

	Edge(int from, int to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public int compareTo(Edge o) {
		return this.from - o.from;
	}
}

public class BOJ_2565_전깃줄 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;

		Edge[] edges = new Edge[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(a, b);
		}

		// Edge의 from으로 정렬
		Arrays.sort(edges);

		int[] dp = new int[N];
		int len = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (edges[j].to < edges[i].to) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			len = Math.max(len, dp[i]);
		}

		System.out.println(N - len);
	}
}
