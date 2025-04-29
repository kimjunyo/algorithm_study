import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 16488	104
public class BOJ_13549_숨바꼭질3_Deque {
	static class Node {
		int pos;
		int sec;

		Node(int pos, int sec) {
			this.pos = pos;
			this.sec = sec;
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 수빈 현재 점 0~100,000
		// 걷기, 순간이동
		// 걷기 : X -> X-1 or X+1
		// 순간이동 : X -> 2*X
		int N = Integer.parseInt(st.nextToken());
		// 동생 현재 점 0~100,000
		int K = Integer.parseInt(st.nextToken());

		Deque<Node> q = new ArrayDeque<>();

		// 이걸 못했음
		boolean[] visited = new boolean[100001];

		q.offer(new Node(N, 0));

		int res = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Node curr = q.poll();
			visited[curr.pos] = true;

			if (curr.pos == K) {
				if (curr.sec < res) {
					res = curr.sec;
				}
			}
			
			// curr.sec에 따라 값이 달라지기 때문에
			// offer할때 pos 값이 같더라도
			// 삽입시 방문처리하면 최소값 탐색을 못할 수도 있다.
			
			// 순간이동
			if (curr.pos * 2 <= 100000 && !visited[curr.pos * 2]) {
				q.offerFirst(new Node(curr.pos * 2, curr.sec));
			}

			// 우
			if (curr.pos < 100000 && !visited[curr.pos + 1]) {
				q.offerLast(new Node(curr.pos + 1, curr.sec + 1));
			}

			// 좌
			if (curr.pos > 0 && !visited[curr.pos - 1]) {
				q.offerLast(new Node(curr.pos - 1, curr.sec + 1));
			}
		}
		System.out.println(res);
	}
}
