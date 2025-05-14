import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Thing {
	int w; // 1 ≤ W ≤ 100,000
	int v; // 0 ≤ V ≤ 1,000

	public Thing(int w, int v) {
		super();
		this.w = w;
		this.v = v;
	}

	@Override
	public String toString() {
		return "Thing [w=" + w + ", v=" + v + "]";
	}

}

public class BOJ_12865_평범한배낭 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 물품의 수 N(1 ≤ N ≤ 100)
		// 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Thing[] arr = new Thing[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[i] = new Thing(w, v);
		}

		// 무게별 최대 가치
		// index -> 무게, 값 -> 가치
		int[] dp = new int[K + 1];
		for (int i = 0; i < N; i++) {
			for (int j = K; j >= arr[i].w; j--) {
				dp[j] = Math.max(dp[j], dp[j - arr[i].w] + arr[i].v);
			}
		}

		System.out.println(dp[K]);
	}
}
