package tip;

import java.util.*;

public class DFS_BFS_배열형태 {
    static int N, M; // 배열 크기
    static int[][] map; // 2차원 배열
    static boolean[][] visited; // 방문 체크 배열

    // 방향 벡터 (동, 서, 남, 북)
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("행과 열을 입력하세요:");
        N = sc.nextInt(); // 행 개수
        M = sc.nextInt(); // 열 개수
        map = new int[N][M];
        visited = new boolean[N][M];

        System.out.println("2차원 배열을 입력하세요:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nDFS 탐색 결과:");
        dfs(0, 0); // (0,0)에서 DFS 시작
        resetVisited(); // 방문 배열 초기화

        System.out.println("\nBFS 탐색 결과:");
        bfs(0, 0); // (0,0)에서 BFS 시작
    }

    // DFS 탐색 (깊이 우선 탐색)
    static void dfs(int x, int y) {
        
    	if (visited[x][y]) return; //필요없긴함
    	
    	// 방문 체크
        visited[x][y] = true;
        System.out.println("방문: (" + x + ", " + y + ")");

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 배열 범위 체크 & 방문 여부 확인
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (!visited[nx][ny] && map[nx][ny] == 1) { //암묵적 리턴
                    dfs(nx, ny);
                }
            }
        }
    }
    
    /* 명시적인 리턴 조건 추가
    static void dfs(int x, int y) {
    // 🔹 1. 배열 범위 벗어나면 리턴
    if (x < 0 || y < 0 || x >= N || y >= M) return;

    // 🔹 2. 이미 방문했거나 갈 수 없는 곳이면 리턴
    if (visited[x][y] || map[x][y] == 0) return;

    // 방문 체크
    visited[x][y] = true;
    System.out.println("방문: (" + x + ", " + y + ")");

    // 4방향 탐색
    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        dfs(nx, ny); // 재귀 호출
    }
}

     */

    // BFS 탐색 (너비 우선 탐색)
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curX = now[0];
            int curY = now[1];
            System.out.println("방문: (" + curX + ", " + curY + ")");

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                // 배열 범위 체크 & 방문 여부 확인
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    // 방문 배열 초기화 (BFS 실행 전 필요)
    static void resetVisited() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
    }
}
