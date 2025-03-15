package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 고층건물_1027 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 주어진 배열 저장.

		int result = 0;
		for (int x = 0; x < n; x++) {
			int y = arr[x];
			// x,y =A건물의 x,y좌표.

			// 현재 건물을 기준으로 보이는 빌딩수.
			int leftcount = 0;
			int rightcount = 0;

			double leftslope = 1_000_000_001; // 기울기.
			// 1.왼쪽 건물.
			for (int bx = x - 1; bx >= 0; bx--) {
				int by = arr[bx];
				// bx,by = B건물의 x,y좌표.

				double curslope = (y - by) / ((x - bx) * 1.0); // B건물까지의 기울기.
				// 기울기가 더 작으면 볼 수 있음.
				if (leftslope > curslope) {
					leftcount++;
					leftslope = curslope;
				}
			}

			// 3. 오른쪽의 높은 건물.
			double rightslope = -1_000_000_001; // 기울기
			for (int bx = x + 1; bx < n; bx++) {
				int by = arr[bx];

				double curslope = (by - y) / ((bx - x) * 1.0);
				// 기울기가 더 크면 볼 수 있음.
				if (rightslope < curslope) {
					rightcount++;
					rightslope = curslope;
				}
			}
			result = Math.max(result, leftcount + rightcount);
		}

		System.out.println(result);

	}
}
