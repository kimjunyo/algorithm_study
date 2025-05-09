import java.util.*;
import java.io.*;

public class BOJ1005_ACM_CRAFT {
    static int[] time, position, value;
    static List<Integer>[] adj;
    static int N, destination;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            time = new int[N + 1];
            adj = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
                adj[i] = new ArrayList<>();
            }

            position = new int[N + 1];

            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                adj[first].add(second);
                position[second]++;
            }

            destination = Integer.parseInt(br.readLine());

            bfs();

            sb.append(value[destination]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> arr = getStart();
        value = new int[N + 1];
        Arrays.fill(value, -1);
        for (int i : arr) {
            value[i] = time[i];
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int input = queue.poll();
                for (int j = 0; j < adj[input].size(); j++) {
                    int next = adj[input].get(j);
                    position[next]--;

                    value[next] = Integer.max(value[input] + time[next], value[next]);

                    if (position[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
    }

    private static List<Integer> getStart() {
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (position[i] == 0) {
                arr.add(i);
            }
        }
        return arr;
    }
}
