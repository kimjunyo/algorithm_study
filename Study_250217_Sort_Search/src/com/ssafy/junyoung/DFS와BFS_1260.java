import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS와BFS_1260 {
	static boolean[] visited;
	static int[][] edge;
	static Queue<Integer> q = new LinkedList<>();
	static int N;
	static int count;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		N = scan.nextInt();
		int M = scan.nextInt();
		int V = scan.nextInt();

		visited = new boolean[N + 1];
		edge = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			int first = scan.nextInt();
			int second = scan.nextInt();

			edge[first][second] = edge[second][first] = 1;
		}

		dfs(V);
		System.out.println();

		visited = new boolean[N + 1];
		bfs(V);
		scan.close();
	}

	private static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");

		if (count == N) {
			return;
		}
		count++;

		for (int i = 1; i <= N; i++) {
			if (edge[v][i] == 1 && visited[i] == false) {
				dfs(i); // 재귀함수를 돌면 dfs
			}
		}
	}

	private static void bfs(int v) {

		q.offer(v);
		visited[v] = true;
		System.out.print(v + " ");

		while (!q.isEmpty()) {
			v = q.poll();

			for (int j = 1; j <= N; j++) {
				if (edge[v][j] == 1 && visited[j] == false) {
					q.offer(j);
					visited[j] = true;
					System.out.print(j + " ");
				}
			}
		}
	}

}