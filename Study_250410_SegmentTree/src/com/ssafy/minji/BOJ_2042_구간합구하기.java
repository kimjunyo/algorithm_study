package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_2042_구간합구하기 {

	static long[] arr;
	static long[] tree;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		arr = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine().trim());
		}
		
		tree = new long[4 * N];
		makeTree(1, 1, N);
		int type;
		int updateIdx;
		long updateVal;
		int start;
		int end;
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < M + K ; i++) {
			st = new StringTokenizer(br.readLine());
			type = Integer.parseInt(st.nextToken());
			if(type == 1) {
				updateIdx = Integer.parseInt(st.nextToken());
				updateVal = Long.parseLong(st.nextToken());
				update(1, updateIdx, updateVal, 1, N);
				arr[updateIdx] = updateVal;
			}else {
				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st.nextToken());
				sb.append(getSum(1, 1, N, start, end)).append("\n");
			}
		}
		System.out.println(sb);
	}

	static void makeTree(int idx, int l, int r) {
		if (l == r) {
			tree[idx] = arr[l];
			return;
		}

		int mid = (l + r) / 2;
		makeTree(idx * 2, l, mid);
		makeTree(idx * 2 + 1, mid + 1, r);
		tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
	}
	
	static void update(int idx, int updateIdx, long updateVal, int l, int r) {
		if(l == r) {
			tree[idx] = updateVal;
			return;
		}
		
		int mid = (l + r) / 2;
		
		if(updateIdx <= mid) {
			update(idx * 2, updateIdx, updateVal, l, mid);
		}else {
			update(idx * 2 + 1, updateIdx, updateVal, mid + 1, r);
		}

		tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
	}
	
	static long getSum(int idx, int l, int r, int start, int end) {
	    if (r < start || l > end) {
	        return 0; // 전혀 겹치지 않으면 무시
	    }

	    if (start <= l && r <= end) {
	        return tree[idx]; // 완전히 포함되면 그 노드 값 리턴
	    }

	    int mid = (l + r) / 2;
	    return getSum(idx * 2, l, mid, start, end) + getSum(idx * 2 + 1, mid + 1, r, start, end);
	}
}
