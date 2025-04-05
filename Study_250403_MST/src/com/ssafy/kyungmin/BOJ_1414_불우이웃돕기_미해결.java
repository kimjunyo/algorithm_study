package graph.mst;

import java.io.*;
import java.util.*;


public class BOJ_1414_불우이웃돕기_미해결 {
    static int N;
    static boolean[] visited;
    static int[][] adj;
    static int[] minEdge;

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new int[N][N];
        visited = new boolean[N];
        minEdge = new int[N];
        Arrays.fill(minEdge, Integer.MAX_VALUE);

        int total = 0;

        // 입력 파싱
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                int cost = 0;

                if (c == '0') continue;
                else if (c >= 'a' && c <= 'z') cost = c - 'a' + 1;
                else cost = c - 'A' + 27;

                adj[i][j] = cost;

                // 총 랜선 길이 계산 (중복 방지 위해 i < j만 포함)
                 total += cost;
            }
        }


        int mstCost = prim();
        
        // 연결이 불가능하면 -1, 아니면 기부할 수 있는 최대 길이 계산
        System.out.println(mstCost == -1 ? -1 : total - mstCost);
    }

    static int prim() {
    	minEdge[0] = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;
            int u = -1;

            // 아직 방문하지 않은 노드 중 최소 간선 선택
            for (int v = 0; v < N; v++) {
                if (!visited[v] && minEdge[v] < min) {
                    min = minEdge[v];
                    u = v;
                }
            }

            if (u == -1) return -1; // 연결 불가능한 경우

            visited[u] = true;
            result += min;

            // 선택된 노드 u로부터 인접 노드의 간선 업데이트
            for (int v = 0; v < N; v++) {
                if (!visited[v] && adj[u][v] != 0 && adj[u][v] < minEdge[v]) {
                    minEdge[v] = adj[u][v];
                }
            }
        }

        return result;

    }
}
