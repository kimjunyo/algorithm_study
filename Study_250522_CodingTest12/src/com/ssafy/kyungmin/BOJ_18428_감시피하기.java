import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18428_감시피하기 {
	static int N;
	static String[][] map;
	static List<int[]> teachers = new ArrayList<>();
	static List<int[]> empties = new ArrayList<>();
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 3~6
		N = Integer.parseInt(br.readLine());

		// X, S, T
		// T 선생님
		// S 학생
		// O 장애물
		map = new String[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken();
				if (map[i][j].equals("T")) {
					teachers.add(new int[] { i, j });
				} else if (map[i][j].equals("X")) {
					empties.add(new int[] { i, j });
				}
			}
		}

		dfs(0, 0);
		System.out.println("NO"); // 끝까지 못찾으면 NO
	}

	// 장애물 3개 설치 조합
	static void dfs(int depth, int start) {
		if (depth == 3) {
			if (simulate()) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}

		for (int i = start; i < empties.size(); i++) {
			int[] pos = empties.get(i);
			map[pos[0]][pos[1]] = "O"; // 장애물 설치
			dfs(depth + 1, i + 1);
			map[pos[0]][pos[1]] = "X"; // 복구
		}
	}

	// 선생님 기준 감시 시뮬레이션
	static boolean simulate() {
		for (int[] teacher : teachers) {
			for (int d = 0; d < 4; d++) {
				int r = teacher[0];
				int c = teacher[1];

				while (true) {
					r += delta[d][0];
					c += delta[d][1];

					if (r < 0 || r >= N || c < 0 || c >= N)
						break;
					if (map[r][c].equals("O"))
						break;
					if (map[r][c].equals("S"))
						return false; // 학생이 감시당함
				}
			}
		}
		return true; // 모든 학생이 감시 피함
	}
}
