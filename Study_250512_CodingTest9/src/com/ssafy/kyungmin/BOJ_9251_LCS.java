import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9251_LCS {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String B = br.readLine();

		int m = A.length();
		int n = B.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1; // 문자가 같으면 -> 대각선+1
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 문자가 다르면 -> 위 or 왼에서 더 큰 값
				}
			}
		}

		System.out.println(dp[m][n]);
	}
}
