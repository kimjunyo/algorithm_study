package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_23970_버블정렬3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int[] ans = new int[N];
		int[] same = new int[N];	// 같은지 비교하는 배열(같으면 0 다르면 1)
		int sameSum = 0;			// 배열합(0일 시 모두 일치)
		for (int i = 0; i < N; i++) {
			ans[i] = Integer.parseInt(st.nextToken());
			if (arr[i] != ans[i]) {	
				same[i] = 1;	// 같으면 인덱스에 1
				sameSum++;		// 배열합 초기값
			}
		}
		
		if(sameSum == 0) {	// 버블정렬 이전에 같은지 비교
			System.out.println(1);
			System.exit(0);
		}

		int temp = 0;

		bubble: 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - i - 1; j++) {

				swap: 
				if (arr[j] > arr[j + 1]) {
					temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;

					// idx값 비교해서 same 배열과 배열합 업데이트
					if (arr[j] == ans[j]) {
						if(same[j] != 0) {	// 1 -> 0 시 배열합 --
							sameSum--;
						}
						same[j] = 0;
					} else {
						if(same[j] != 1) {	// 0 -> 1 시 배열합 ++
							sameSum++;
						}
						same[j] = 1;
					}

					if (arr[j + 1] == ans[j + 1]) {
						if(same[j + 1] != 0) {
							sameSum--;
						}
						same[j + 1] = 0;
					} else {
						if(same[j + 1] != 1) {
							sameSum++;
						}
						same[j + 1] = 1;
					}

					// 배열이 일치하지 않으면 다음 정렬로 넘어감
					if(sameSum != 0) {
						break swap;
					}
					
					// 배열이 일치하므로 1 출력 후 종료
					System.out.println(1);
					break bubble;
				}
			}
			// 최댓값 끝으로 정렬하고 고정된 값이 일치하지 않을 시 무조건 0
			if (arr[N - i - 1] != ans[N - i - 1]) {
				System.out.println(0);
				break bubble;
			}
		}

	}
}
