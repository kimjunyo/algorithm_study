import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class GR_49051_불이야 {
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static char[][] arr;
	static int R, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 1~R,C~1000
		// R줄, 길이 C문자열
		// . -> 불 번질수 잇음
		// # -> 불 번질수 없음
		// & -> 구름이
		// @ -> 불
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		int[] goorm = new int[] { -1, -1 };
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
				if (str.charAt(j) == '&') {
					goorm[0] = i;
					goorm[1] = j;
				}
			}
		}

		Queue<List<int[]>> q = new LinkedList<>();
		List<int[]> list = new ArrayList<>();
		list.add(new int[] { goorm[0], goorm[1] });
		q.offer(list);

		int num = 0;
		boolean fireIsNear = false;

		loop: while (!q.isEmpty()) {
			if (num == -1)
				break;

			List<int[]> coors = q.poll();

			List<int[]> nextList = new ArrayList<>();

			for (int[] coor : coors) {
				arr[coor[0]][coor[1]] = '&';

				for (int i = 0; i < dr.length; i++) {
					int nr = coor[0] + dr[i];
					int nc = coor[1] + dc[i];

					if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
						switch (arr[nr][nc]) {
						case '.':
							nextList.add(new int[] { nr, nc });
							break;
						case '#':
							break;
						case '@':
							fireIsNear = true;
							break loop;
						default:
							break;
						}
					}
				}
			}

			num++;

			if (nextList.size() > 0)
				q.offer(nextList);
			

		}
		if (num > 1000000 || !fireIsNear) {
			System.out.println(-1);
		} else {
			System.out.println(num);
		}
	}
}