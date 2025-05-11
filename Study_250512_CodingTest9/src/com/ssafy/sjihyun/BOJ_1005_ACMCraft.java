import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] time = new int[N + 1];
            int[] inDegree = new int[N + 1];
            int[] dp = new int[N + 1];
            
            List<Integer>[] graph = new ArrayList[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                inDegree[v]++;
            }

            int target = Integer.parseInt(br.readLine());
            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= N; i++) {
                dp[i] = time[i];
                if (inDegree[i] == 0) {
                    q.offer(i);
                }
            }

            while (!q.isEmpty()) {
                int node = q.poll();
                for (int n : graph[node]) {
                    dp[n] = Math.max(dp[n], dp[node] + time[n]);
                    inDegree[n]--;
                    if (inDegree[n] == 0) q.offer(n);
                }
            }
            sb.append(dp[target]).append("\n");
        }
        System.out.println(sb);
    }
}
