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
		n = N;// 전체 선수의 수 
		l = L; //전체 리그의 수
		m = N / L; //각 리그당 선수의 수 
		arr = new Node[l][m]; //각 리그별(행) 선수들의 ability, id 정보를 저장. 조건에 맞게 정렬하여 저장.
		int index = 0;
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = new Node(index, mAbility[index++]);
			}
			Arrays.sort(arr[i]);
		} // 행 = 리그번호, 열=선수정보(id,ability)

	}// init

	int move() {
		boolean[] isMove = new boolean[n]; // 중복 저장 방지용
		int moveSum = 0; //이동한 선수들의 id의 총합. 

		for (int i = 1; i < l; i++) {

			Node tmp = arr[i - 1][m - 1]; // 상위 리그의 최악선수.
			arr[i - 1][m - 1] = arr[i][0];// 현재 리그의 최고 선수와 자리 바꿈.
			arr[i][0] = tmp;

			// 각 리그별 선수가 한명일때 중복 이동이 일어날수 있으므로 중복 제외하여 저장.
			if (!isMove[arr[i - 1][m - 1].id]) {
				isMove[arr[i - 1][m - 1].id] = true;
				moveSum += arr[i - 1][m - 1].id;
			}
			if (!isMove[arr[i][0].id]) {
				isMove[arr[i][0].id] = true;
				moveSum += arr[i][0].id;
			}

		}
		sortMove(); // 이동후 각 리그별 조건에 맞게 저장.

		return moveSum;
	}

	int trade() {
		boolean[] isMove = new boolean[n]; //이동한 선수 중복 저장 방지
		int moveSum = 0; // 이동한 선수들의 id의 총합 
		for (int i = 1; i < l; i++) {
			Node mid = arr[i - 1][m / 2]; // 상위 리그 중간선수.
			arr[i - 1][m / 2] = arr[i][0]; // 현재 리그 최고선수와 바꿈.
			arr[i][0] = mid;
			// 각 리그별 선수가 한명일때 중복 이동이 일어날수 있으므로 중복 제외하여 저장.
			if (!isMove[arr[i - 1][m / 2].id]) {
				isMove[arr[i - 1][m / 2].id] = true;
				moveSum += arr[i - 1][m / 2].id;
			}
			if (!isMove[arr[i][0].id]) {
				isMove[arr[i][0].id] = true;
				moveSum += arr[i][0].id;
			}

		}
		sortTrade(); //trade후 각 리그 조건에 맞게 정렬

		return moveSum;
	}

	//나머지는 정렬이 된 상태이므로 두명만 정렬하면됨.
	void sortMove() {
		for (int i = 0; i < l; i++) {
			Node downNode = arr[i][0];// 상위 리그에서 내려온 선수
			Node upNode = arr[i][m - 1]; // 하위 리그에서 올라온 선수
			int downIndex = 0;
			int upIndex = m - 1;

			// 이동한 선수들만 정렬시키면 됨.
			//내려온 선수는 현재 위치에서 오른쪽으로 이동하며 위치 찾아감.
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

			//올라온 선수는 왼쪽으로 이동하면서 위치 찾아감. 
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

	
	//나머지는 정렬된 상태이므로 트래이드한 선수 두명만 제자리를 찾아가면 됨.
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

			//리그의 중간에 들어온 선수는 왼쪽선수와 바꿔야하는지 오른쪽선수와 바꿔야하는지 모르므로 둘다 함.
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
	
	//각 선수들의 id와 ability저장
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
