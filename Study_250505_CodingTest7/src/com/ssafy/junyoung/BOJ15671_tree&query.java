import java.util.*;
import java.io.*;

public class Main {
	static List<Integer>[] adj;
	static boolean[] visited;
	static int[] subsequence;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		subsequence = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			adj[first].add(second);
			adj[second].add(first);
		}

		visited = new boolean[N + 1];
		dfs(R);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			int root = Integer.parseInt(br.readLine());

			sb.append(subsequence[root]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
	}

	private static void dfs(int root) {
		subsequence[root] = 1;
		visited[root] = true;

		for (int next : adj[root]) {
			if (!visited[next]) {
				dfs(next);
				subsequence[root] += subsequence[next];
			}
		}
	}
}
