import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class GR_49112_징검다리건너기 {
	static class Node implements Comparable<Node> {
		int index;
		int sum;

		Node(int index, int sum) {
			this.index = index;
			this.sum = sum;
		}

		@Override
		public String toString() {
			return "Node [index=" + index + ", sum=" + sum + "]";
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.sum, o.sum);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] poisons = new int[N];
		// 돌의 개수 1~100000
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int p = Integer.parseInt(st.nextToken());
			poisons[i] = p;
		}

		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < Math.min(3, N); i++) {
			dist[i] = poisons[i];
			pq.offer(new Node(i, poisons[i]));
		}

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (curr.index == N - 1 || curr.index == N - 2 || curr.index == N - 3) {
				System.out.println(curr.sum);
				return;
			}

			if (curr.sum > dist[curr.index])
				continue;

			for (int i = 1; i <= 3; i++) {
				int next = curr.index + i;
				if (next < N && dist[next] > curr.sum + poisons[next]) {
					dist[next] = curr.sum + poisons[next];
					pq.offer(new Node(next, dist[next]));
				}
			}
		}
	}
}