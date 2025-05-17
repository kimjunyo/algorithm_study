import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2623_음악프로그램 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 가수 N 1 ~ 1000
		// 1, 2, 3, ...
		int N = Integer.parseInt(st.nextToken());
		// 보조PD M 1 ~ 100
		// 문제에선 사실상 별 필요없는애
		int M = Integer.parseInt(st.nextToken());

		List<Integer>[] adjlist = new ArrayList[N + 1];
		for (int i = 0; i < adjlist.length; i++) {
			adjlist[i] = new ArrayList<>();
		}

		// 진입 차수
		int[] degree = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			int[] arr = new int[length];

			int prev = 0;
			for (int j = 0; j < length; j++) {
				int to = Integer.parseInt(st.nextToken());
				if (j > 0) {
					adjlist[prev].add(to);
					degree[to]++;
				}
				arr[j] = to;
				prev = to;
			}
		}

		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i < N + 1; i++) {
			if (degree[i] == 0) {
				// 진입차수가 0인 경우 정점 0 넣기
				q.add(i);
			}
		}

		List<Integer> result = new ArrayList<>();
		while (!q.isEmpty()) {
			int curr = q.poll();
			result.add(curr);

			for (int to : adjlist[curr]) {
				degree[to]--;
				if (degree[to] == 0) {
					q.add(to);
				}
			}
		}

		// 사이클이 발생한 경우
		if (result.size() != N) {
			System.out.println(0);
		} else {
			for (int singer : result) {
				System.out.println(singer);
			}
		}
	}
}