import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int[][] map;
    static int[][] cost;

    private static void findMinCost() {
        PriorityQueue<int[]> q = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[2], e2[2]));
        cost[0][0] = map[0][0];
        q.offer(new int[]{0, 0, cost[0][0]});

        while (!q.isEmpty()) {
            int[] out = q.poll();
            int x = out[0];
            int y = out[1];
            int c = out[2];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    int currCost = c + map[nx][ny];
                    if (currCost < cost[nx][ny]) {
                        cost[nx][ny] = currCost;
                        q.offer(new int[]{nx, ny, cost[nx][ny]});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            
            sb.append("Problem "+ (tc++) + ": ");
            map = new int[N][N];
            cost = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }
            findMinCost();
            sb.append(cost[N-1][N-1]).append("\n");
        }
        System.out.print(sb);
    }
}
