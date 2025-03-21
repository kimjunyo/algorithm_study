package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1976_여행가자 {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine().trim());
		int M = Integer.parseInt(br.readLine().trim());
		
		arr = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i] = i;
		}

		// 2차원 배열 : j-j, j-i 두 번 표현하므로 한 번씩만 검사
		int num = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < i; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					root(i, j);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int city1 = 0;
		int city2 = Integer.parseInt(st.nextToken());
		boolean able = true;
		
		// (1, 2) - (2, 3) - (3, 4) ...
		for (int i = 1; i < M; i++) {
			city1 = city2;
			city2 = Integer.parseInt(st.nextToken());
			if(find(city1) != find(city2)) {
				able = false;
				break;
			}
		}
		System.out.println(able ? "YES" : "NO");
	}

	static int find(int x) {
	    if (arr[x] != x) {
	        arr[x] = find(arr[x]);  // 경로 압축
	    }
	    return arr[x];
	}

	static void root(int a, int b) {
	    int rootA = find(a);
	    int rootB = find(b);
	    if (rootA != rootB) {
	        arr[rootB] = rootA; // or arr[rootA] = rootB
	    }
	}
}

