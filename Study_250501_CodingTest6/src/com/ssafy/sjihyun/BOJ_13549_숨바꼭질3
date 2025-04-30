import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int max = 100001;

        int[] dp = new int[max];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N] = 0; 

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(N);

        while (!dq.isEmpty()) {
            int n = dq.poll();

            if (n * 2 < max && dp[n * 2] > dp[n]) {
                dp[n * 2] = dp[n];
                dq.offerFirst(n * 2);
            }

            if (n + 1 < max && dp[n + 1] > dp[n] + 1) {
                dp[n + 1] = dp[n] + 1;
                dq.offerLast(n + 1);
            }
            if (n - 1 >= 0 && dp[n - 1] > dp[n] + 1) {
                dp[n - 1] = dp[n] + 1;
                dq.offerLast(n - 1);
            }
        }
        System.out.println(dp[M]);
    }
}
