package 알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 블랙프라이데이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		// 물건들의 무게를 저장할 배열
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		// 1개일때 같으면 1반환.
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == c) {
				System.out.println(1);
				return;
			}
		}
		Arrays.sort(arr);

		// 2개일때 같으면 1반환.
		for (int i = 0; i < n - 1; i++) {
			// 나머지 뺀 값이 이후 배열에 있는지 이분탐색으로 찾으면 됨.
			int rest = c - arr[i];
			if (rest < 0)
				break;
			// 이분탐색으로 있으면 나머지값 있으면 반환.
			if (binarySearch(arr, i + 1, n - 1, rest)) {
				System.out.println(1);
				return;
			}
		}

		// 3개일때 같으면 반환.
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				//
				int rest = c - arr[i] - arr[j];
				if (rest < 0)
					break;

				if (binarySearch(arr, j + 1, n - 1, rest)) {
					System.out.println(1);
					return;
				}
			}
		}

		System.out.println(0);

	}

	public static boolean binarySearch(int[] arr, int start, int end, int key) {
		int s = start;
		int e = end;
		int mid;
		while (s <= e) {
			mid = (s + e) / 2;
			if (arr[mid] == key)
				return true;
			else if (arr[mid] > key)
				e = mid - 1;
			else
				s = mid + 1;
		}
		return false;
	}

}
