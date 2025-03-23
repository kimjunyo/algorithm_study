package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1717_집합의표현 {
	private static int[] parent;
	private static int[] rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		rank = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}

		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int TYPE = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (TYPE == 0) {
				union(a, b);
//				System.out.println(a + "," + b + Arrays.toString(parent));
//				System.out.println(Arrays.toString(rank));
			} else {
				if (find(a) == find(b)) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
			System.out.println(a + "," + b + Arrays.toString(parent));
		}
		System.out.print(sb);
	}

	private static void union(int a, int b) {
		if (a == b)
			return;

		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			if (rank[rootA] < rank[rootB]) {
				parent[rootA] = rootB;
			} else if (rank[rootA] > rank[rootB]) {
				parent[rootB] = rootA;
			} else {
				parent[rootB] = rootA;
				rank[rootA]++;
			}
		}
	}

	private static int find(int x) {
		if (parent[x] != x) {
			return parent[x] = find(parent[x]);
		}
		return x;
	}
}
