package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 전깃줄 {
	static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		Node[] arr = new Node[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Node(a, b);
		}
		Arrays.sort(arr);

		for (Node node : arr) {
			int target = node.b;
			binary(target);
		}
		System.out.println(n - list.size());

	}

	static void binary(int target) {
		int s = 0;
		int e = list.size() - 1;
		if (e == -1 || list.get(e) < target) {
			list.add(target);
			return;
		}
		if (list.get(s) >= target) {
			list.set(s, target);
			return;
		}

		while (s < e) {
			if (s + 1 == e) {
				list.set(e, target);
				return;
			}
			int mid = (s + e) / 2;
			int midNum = list.get(mid);

			if (midNum == target)
				return;
			else if (midNum > target) {
				e = mid - 1;
				if (target > list.get(e)) {
					list.set(mid, target);
					return;
				}
			} else {
				s = mid + 1;
				if (target < list.get(s)) {
					list.set(s, target);
					return;
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int a, b;

		public Node(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int compareTo(Node o) {
			return this.a - o.a;
		}
	}

}
