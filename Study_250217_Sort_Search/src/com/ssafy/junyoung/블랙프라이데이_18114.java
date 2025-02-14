package 블랙프라이데이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 블랙프라이데이_18114 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] weights = new int[N];

		for (int i = 0; i < N; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
			if (weights[i] == C) {
				System.out.println(1);
				return;
			}
		}
		Arrays.sort(weights);

		outer: for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int input = weights[i] + weights[j];
				if (input == C) {
					System.out.println(1);
					return;
				} else if (input > C) {
					continue outer;
				} else {
					int search = Arrays.binarySearch(weights, C - input);
					if (search >= 0 && search != i && search != j) {
						System.out.println(1);
						return;
					}
				}
//				for (int k = j + 1; k < N; k++) {
//					if (weights[i] + weights[j] + weights[k] == C) {
//						System.out.println(1);
//						return;
//					} else if (weights[i] + weights[j] + weights[k] > C) {
//						break;
//					}
//				}
			}
		}
		System.out.println(0);

	}
}
