package 스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 통나무건너뛰기_11497 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cases = Integer.parseInt(st.nextToken());
		StringBuilder result = new StringBuilder();
		for (int t = 1; t <= cases; t++) {
			int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			// 통나무차이 최솟값찾기 정렬후 가장 큰차이를 초기값으로 설정.

			int[] newArr = new int[n];
			// 새로운배열에 맨앞 맨뒤에서 가운데로 가면서 큰숫자를 순서대로 입력.
			boolean eisOk = true;
			int e = n - 1;
			int s = 0;
			for (int i = n - 1; i >= 0; i--) {
				int num = arr[i];
				if (eisOk) {
					newArr[e] = num;
					eisOk = false;
					e--;
				} else {
					newArr[s] = num;
					eisOk = true;
					s++;
				}
			}
			int diffmin = 0;
			for (int i = 0; i < n - 1; i++) {
				diffmin = Math.max(diffmin, Math.abs(newArr[i] - newArr[i + 1]));
			}
			result.append(diffmin).append("\n");
		}
		bw.write(result.toString().trim());
		bw.flush();
	}

}
