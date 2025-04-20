package simulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SWEA_승강제리그 {

	static class UserSolution {
		class Player implements Comparable<Player> {
			int id;
			int ability;

			Player(int id, int ability) {
				this.id = id;
				this.ability = ability;
			}

			@Override
			public int compareTo(Player o) {
				if (this.ability == o.ability) {
					return this.id - o.id;
				}
				return o.ability - this.ability;
			}

			@Override
			public String toString() {
				return "Player [id=" + id + ", ability=" + ability + "]";
			}
		}

		Player[][] arrangement;

		// N : 선수들의 수 (9 ≤ N ≤ 39,990)
		// L : 리그의 개수 (3 ≤ L ≤ 10, 3 ≤ N / L ≤ 3,999)
		// mAbility : 각 선수들의 능력 값 (1 ≤ mAbility[] ≤ 10,000)
		void init(int N, int L, int mAbility[]) {
			int players = N / L;

			arrangement = new Player[L][players];

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < players; j++) {
					int id = i * players + j;
					arrangement[i][j] = new Player(id, mAbility[id]);
				}
			}

//			for (int i = 0; i < arrangement.length; i++) {
//				System.out.println(Arrays.toString(arrangement[i]));
//			}
		}

		int move() {
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < arrangement.length; i++) {
				Arrays.sort(arrangement[i]);

				if (i == 0) {
					continue;
				}

				int lastIndex = arrangement[i].length - 1;

				Player top = arrangement[i][0];

				arrangement[i][0] = arrangement[i - 1][lastIndex];
				arrangement[i - 1][lastIndex] = top;

//				System.out.println(top.id);
//				System.out.println(league[0].id);
//				System.out.println();

				set.add(top.id);
				set.add(arrangement[i][0].id);
			}

			return getSum(set);
		}

		int trade() {
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < arrangement.length; i++) {
				Arrays.sort(arrangement[i]);

				if (i == 0)
					continue;

				Player top = arrangement[i][0];

				int middleIndex = arrangement[i].length / 2;
				arrangement[i][0] = arrangement[i - 1][middleIndex];
				arrangement[i - 1][middleIndex] = top;

				set.add(top.id);
				set.add(arrangement[i][0].id);
			}

			return getSum(set);
		}

		int getSum(Set<Integer> set) {
			int sum = 0;
			for (int i : set) {
				sum += i;
			}
			return sum;
		}

	}

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
//				System.out.println(ret);
				ans = sc.nextInt();
				if (ans != ret) {
					ok = false;
				}
			} else if (query == CMD_TRADE) {
				int ret = usersolution.trade();
//				System.out.println(ret);
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