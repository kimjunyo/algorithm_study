package com.ssafy.yeook;

import java.util.Arrays;
import java.util.Scanner;

public class 승강제리그 {
	private static Scanner sc;
	private static UserSolution usersolution = new UserSolution();

	private final static int CMD_INIT = 100;
	private final static int CMD_MOVE = 200;
	private final static int CMD_TRADE = 300;

	private static boolean run() throws Exception {

		int query_num = sc.nextInt();
		int ans;
		boolean ok = false;

		for (int q = 0; q < query_num; q++) {
			int query = sc.nextInt();

			if (query == CMD_INIT) {
				int N = sc.nextInt();
				int L = sc.nextInt();
				int mAbility[] = new int[N];
				for (int i = 0; i < N; i++) {
					mAbility[i] = sc.nextInt();
				}
				usersolution.init(N, L, mAbility);
				ok = true;
			} else if (query == CMD_MOVE) {
				int ret = usersolution.move();
				ans = sc.nextInt();
				if (ans != ret) {
					ok = false;
				}
			} else if (query == CMD_TRADE) {
				int ret = usersolution.trade();
				ans = sc.nextInt();
				if (ans != ret) {
					ok = false;
				}
			}
		}
		return ok;
	}

	public static void main(String[] args) throws Exception {
		int T, MARK;

		// System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		sc = new Scanner(System.in);
		T = sc.nextInt();
		MARK = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int score = run() ? MARK : 0;
			System.out.println("#" + tc + " " + score);
		}
		sc.close();
	}
}

class UserSolution {

	static int n, l, m;
	static Node[][] arr;

	void init(int N, int L, int mAbility[]) {
		n = N;
		l = L;
		m = N / L;
		arr = new Node[l][m];
		int index = 0;
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = new Node(index, mAbility[index++]);
			}
			Arrays.sort(arr[i]);
		} // 행 = 리그번호, 열=선수정보(id,ability)

	}// init

	int move() {
		boolean[] isMove = new boolean[n];
		int moveSum = 0;

		for (int i = 1; i < l; i++) {

			Node tmp = arr[i - 1][m - 1]; // 상위 리그의 최악선수.
			arr[i - 1][m - 1] = arr[i][0];// 현재 리그의 최고 선수와 자리 바꿈.
			arr[i][0] = tmp;

			// 각 리그별 선수가 한명일때..
			if (!isMove[arr[i - 1][m - 1].id]) {
				isMove[arr[i - 1][m - 1].id] = true;
				moveSum += arr[i - 1][m - 1].id;
			}
			if (!isMove[arr[i][0].id]) {
				isMove[arr[i][0].id] = true;
				moveSum += arr[i][0].id;
			}

		}
		sortMove();

		return moveSum;
	}

	int trade() {
		boolean[] isMove = new boolean[n];
		int moveSum = 0;
		for (int i = 1; i < l; i++) {
			Node mid = arr[i - 1][m / 2]; // 상위 리그 중간선수.
			arr[i - 1][m / 2] = arr[i][0]; // 현재 리그 최고선수와 바꿈.
			arr[i][0] = mid;
			// 각 리그별 선수가 한명일때..
			if (!isMove[arr[i - 1][m / 2].id]) {
				isMove[arr[i - 1][m / 2].id] = true;
				moveSum += arr[i - 1][m / 2].id;
			}
			if (!isMove[arr[i][0].id]) {
				isMove[arr[i][0].id] = true;
				moveSum += arr[i][0].id;
			}

		}
		sortTrade();

		return moveSum;
	}

	void sortMove() {
		for (int i = 0; i < l; i++) {
			Node downNode = arr[i][0];
			Node upNode = arr[i][m - 1];
			int downIndex = 0;
			int upIndex = m - 1;
			while (downIndex < m - 1) {
				if ((downNode.ability < arr[i][downIndex + 1].ability)
						|| (downNode.ability == arr[i][downIndex + 1].ability
								&& downNode.id > arr[i][downIndex + 1].id)) {
					arr[i][downIndex] = arr[i][downIndex + 1];
					downIndex++;
					if (downIndex == upIndex)
						upIndex--;
				} else
					break;
			}
			arr[i][downIndex] = downNode;

			while (upIndex > 0) {
				if ((upNode.ability > arr[i][upIndex - 1].ability)
						|| (upNode.ability == arr[i][upIndex - 1].ability && upNode.id < arr[i][upIndex - 1].id)) {
					arr[i][upIndex] = arr[i][upIndex - 1];
					upIndex--;
				} else
					break;
			}
			arr[i][upIndex] = upNode;

		}
	}// sortMove

	void sortTrade() {
		for (int i = 0; i < l; i++) {
			Node downNode = arr[i][0];
			Node tradeNode = arr[i][m / 2];
			int downIndex = 0;
			int tradeIndex = m / 2;
			while (downIndex < m - 1) {
				if ((downNode.ability < arr[i][downIndex + 1].ability)
						|| (downNode.ability == arr[i][downIndex + 1].ability
								&& downNode.id > arr[i][downIndex + 1].id)) {
					arr[i][downIndex] = arr[i][downIndex + 1];

					downIndex++;
					if (downIndex == tradeIndex)
						tradeIndex--;
				} else
					break;
			}
			arr[i][downIndex] = downNode;

			if (tradeIndex > 0 && tradeIndex < m - 1) {
				if ((tradeNode.ability > arr[i][tradeIndex - 1].ability)
						|| (tradeNode.ability == arr[i][tradeIndex - 1].ability
								&& tradeNode.id < arr[i][tradeIndex - 1].id)) {

					while (tradeIndex > 0) {
						if ((tradeNode.ability > arr[i][tradeIndex - 1].ability)
								|| (tradeNode.ability == arr[i][tradeIndex - 1].ability
										&& tradeNode.id < arr[i][tradeIndex - 1].id)) {
							arr[i][tradeIndex] = arr[i][tradeIndex - 1];
							tradeIndex--;
						} else
							break;
					}
				}

				if ((tradeNode.ability < arr[i][tradeIndex + 1].ability)
						|| (tradeNode.ability == arr[i][tradeIndex + 1].ability
								&& tradeNode.id > arr[i][tradeIndex + 1].id)) {

					while (tradeIndex < m - 1) {
						if ((tradeNode.ability < arr[i][tradeIndex + 1].ability)
								|| (tradeNode.ability == arr[i][tradeIndex + 1].ability
										&& tradeNode.id > arr[i][tradeIndex + 1].id)) {
							arr[i][tradeIndex] = arr[i][tradeIndex + 1];

							tradeIndex++;
						} else
							break;
					}
				}

			}

			arr[i][tradeIndex] = tradeNode;

		}

	}

	class Node implements Comparable<Node> {
		int id;
		int ability;

		public Node(int id, int ability) {
			this.id = id;
			this.ability = ability;
		}

		// 능력은 큰 순으로, 아이디는 작은순으로
		@Override
		public int compareTo(Node o) {
			if (this.ability == o.ability)
				return this.id - o.id;
			else
				return o.ability - this.ability;
		}

	}

}