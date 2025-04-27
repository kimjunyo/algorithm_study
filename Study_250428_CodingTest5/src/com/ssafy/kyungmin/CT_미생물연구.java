import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class CT_미생물연구 {
	static class Node {
		int num;
		int area;

		Node(int num, int area) {
			this.num = num;
			this.area = area;
		}

		@Override
		public String toString() {
			return "Node [num=" + num + ", area=" + area + "]";
		}

	}

	static int[][] arr;
	static int[][] tests;
	static Map<Integer, Node> areasMap;
	static PriorityQueue<Node> areasQ;
	static boolean[][] visited;
	static int N, Q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 2~N~15
		N = Integer.parseInt(st.nextToken());
		// 1~Q~50
		Q = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		tests = new int[Q][4];
		areasMap = new HashMap<>();
		areasQ = new PriorityQueue<>((a, b) -> Long.compare(b.area, a.area));

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int[] test = new int[4];
			for (int j = 0; j < 4; j++) {
				test[j] = Integer.parseInt(st.nextToken());
			}
			Node n = new Node(i + 1, ((test[2] - test[0]) * (test[3] - test[1])));
			areasMap.put(n.num, n);
			tests[i] = test;
		}

		for (int tc = 1; tc <= Q; tc++) {
			int r1 = tests[tc - 1][0];
			int c1 = tests[tc - 1][1];
			int r2 = tests[tc - 1][2];
			int c2 = tests[tc - 1][3];

			if (tc == 1) {
				tests[tc - 1][0] = 0;
				tests[tc - 1][1] = 0;
				tests[tc - 1][2] = r2 - r1;
				tests[tc - 1][3] = c2 - c1;
				for (int i = 0; i < r2 - r1; i++) {
					for (int j = 0; j < c2 - c1; j++) {
						arr[i][j] = tc;
					}
				}
				areasQ.offer(areasMap.get(1));
			} else {
				for (int i = r1; i < r2; i++) {
					for (int j = c1; j < c2; j++) {
						if (arr[i][j] > 0 && arr[i][j] != tc) {
							areasMap.get(arr[i][j]).area--;
						}
						arr[i][j] = tc;
					}
				}
				areasQ.offer(areasMap.get(tc));
				System.out.println(areasQ);
				System.out.println(areasMap);

				for (int i = 0; i < N; i++) {
					System.out.println(Arrays.toString(arr[i]));
				}

				int[] nextColCoor = new int[] { -1, -1 };
				int[] nextRowCoor = new int[] { -1, -1 };
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (nextColCoor[1] == -1 && arr[i][j] == 0) {
							nextColCoor[0] = i;
							nextColCoor[1] = j;
						}
						if (nextRowCoor[0] == -1 && arr[j][i] == 0) {
							nextRowCoor[0] = i;
							nextRowCoor[1] = j;
						}
					}
				}
				System.out.println(Arrays.toString(nextColCoor) + ", " + Arrays.toString(nextRowCoor));

				int[] prevTest = tests[tc - 2];
				// x좌표
				if (c2 - c1 + prevTest[1] - prevTest[3] <= N) {
					int h = c2 - c1;
					int w = r2 - r1;
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N; j++) {
							if (i >= nextColCoor[0] && i < nextColCoor[0] + w && j >= nextColCoor[1]
									&& j < nextColCoor[1] + h) {
								arr[i][j] = tc;
							} else if (arr[i][j] == tc) {
								arr[i][j] = 0;
							}
						}
					}
				} else {
				}

			}
		}

		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}