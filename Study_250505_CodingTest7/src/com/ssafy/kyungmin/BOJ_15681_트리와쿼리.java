import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15681_트리와쿼리 {

	static List<List<Integer>> tree = new ArrayList<>();
	static int[] subtree;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 트리 정점의 수
		// 2~10^5
		int N = Integer.parseInt(st.nextToken());
		// 루트의 번호 R
		// 1~N
		int R = Integer.parseInt(st.nextToken());
		// 쿼리의 수
		// 1~10^5
		int Q = Integer.parseInt(st.nextToken());

		subtree = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			List<Integer> l = new ArrayList<>();
			tree.add(l);
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			tree.get(U).add(V);
			tree.get(V).add(U);
		}

		dfs(R);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			int q = Integer.parseInt(br.readLine());
			sb.append(subtree[q]).append("\n");
		}

		System.out.print(sb);
	}

	static int dfs(int node) {
		visited[node] = true;
		int size = 1;
		for (int child : tree.get(node)) {
			if (!visited[child]) {
				size += dfs(child);
			}
		}
		return subtree[node] = size;
	}
}
