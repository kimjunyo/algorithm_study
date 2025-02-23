package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타레슨_2343 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		// 블루레이 크기별로 m을 만족하는 것들 중 가장 작은 것을 출력.
		// 블루레이의 크기는 이분탐색으로 선정함.

		int start = 0; // 강의들 중 가장 긴것을 저장. -> 이분탐색시 맨 처음이 될 값.
		// 주어진 강의들을 누적합으로 저장.
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = arr[i - 1] + num;
			start = Math.max(start, num);
		} // 저장.

		// 블루레이 사이즈중 가장 큰값.
		int end = arr[n];

		int result = end;
		int count;
		int preIndex;
		int mid;
		while (start <= end) {
			count = 1;
			preIndex = 0;
			mid = (start + end) / 2; // 블루레이 크기.

			for (int i = 1; i <= n; i++) {
				if (arr[i] - arr[preIndex] > mid) {
					count++;
					preIndex = i - 1;
				}
			}

			// 해당 블루레이크기로 m개이하로 나뉘어지면 결과에 저장 후 작은 블루레이를 탐색해봄.
			if (count <= m) {
				result = Math.min(result, mid);
				end = mid - 1;
				// 나뉜것이 많으면 블루레이크기를 키움.
			} else {
				start = mid + 1;
			}

		}
		System.out.println(result);

		// 블루레이의 크기를 이분탐색하며 가능한 것들 중 가장 작은 값을 출력함.

	}
}
