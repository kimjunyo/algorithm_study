package baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 블랙프라이데이_18114 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int C = sc.nextInt();
		int[] arr = new int[N];
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			set.add(arr[i]);
		}
		// 1개인지 검사
		if (set.contains(C)) {
			System.out.println("1");
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int sum = arr[i] + arr[j];
				// 2개인지 검사
				if (sum == C) {
					System.out.println("1");
					return;
				}
				//3개인지 검사
				if (sum < C && set.contains(C - sum)) {
					System.out.println("1");
					return;
				}
			}
		}
		System.out.println(0);
	}
}
