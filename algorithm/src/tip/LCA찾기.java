package tip;

import java.io.*;
import java.util.*;

public class LCA찾기 {

    static int[] parent, depth;
    static List<Integer>[] children;
    static StringBuilder sb;

    // DFS를 이용한 깊이 계산
    private static void computeDepth(int node, int d) {
        depth[node] = d;
        for (int child : children[node]) {
            computeDepth(child, d + 1);
        }
    }

    // 소 공통 조상(LCA) 찾기 (O(log V))
    private static int findAncestor(int A, int B) {
        // 1️ 깊이를 맞춤
        while (depth[A] > depth[B]) A = parent[A];
        while (depth[B] > depth[A]) B = parent[B];

        // 2️ 동시에 부모를 따라 올라가며 LCA 찾기
        while (A != B) {
            A = parent[A];
            B = parent[B];
        }
        return A; // LCA 반환
    }

    //  서브트리 크기 구하기 (BFS)
    private static int findChildren(int root) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(root);

        int cnt = 1; // 자기 자신 포함
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int child : children[node]) {
            	cnt++;
                queue.offer(child);
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력

        sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            // 📌 입력 처리
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 정점 개수
            int E = Integer.parseInt(st.nextToken()); // 간선 개수
            int target1 = Integer.parseInt(st.nextToken()); // LCA를 찾을 첫 번째 노드
            int target2 = Integer.parseInt(st.nextToken()); // LCA를 찾을 두 번째 노드

            parent = new int[V + 1]; // 부모 정보 저장
            depth = new int[V + 1]; // 깊이 저장 배열
            children = new ArrayList[V + 1]; // 자식 리스트

            for (int i = 1; i <= V; i++) {
                children[i] = new ArrayList<>();
            }

            // 📌 부모-자식 관계 저장
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int u = Integer.parseInt(st.nextToken()); // 부모
                int v = Integer.parseInt(st.nextToken()); // 자식
                parent[v] = u;
                children[u].add(v);
            }

            //  루트(1번 노드)부터 깊이 계산
            computeDepth(1, 0);
            //  최소 공통 조상 찾기 (LCA)
            int ancestor = findAncestor(target1, target2);
            //  서브트리 크기 계산
            int subtreeSize = findChildren(ancestor);
            //  결과 출력 최적화
            sb.append("#").append(tc).append(" ").append(ancestor).append(" ").append(subtreeSize).append("\n");
        }
        System.out.print(sb); // 한 번만 출력
    }
}
