import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1005_ACMCraft {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] time = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}

			// 그래프 
			List<List<Integer>> graph = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				graph.add(new ArrayList<>());
			}

			// 위상 정렬
			int[] inDegree = new int[N + 1];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				graph.get(X).add(Y);
				inDegree[Y]++;
			}

			int W = Integer.parseInt(br.readLine());

			int[] dp = new int[N + 1];
			Queue<Integer> q = new ArrayDeque<>();

			for (int i = 1; i <= N; i++) {
				if (inDegree[i] == 0) {
					dp[i] = time[i];
					q.add(i);
				}
			}

			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int next : graph.get(cur)) {
					dp[next] = Math.max(dp[next], dp[cur] + time[next]);
					inDegree[next]--;
					if (inDegree[next] == 0) {
						q.add(next);
					}
				}
			}

			System.out.println(dp[W]);
		}
	}
}
