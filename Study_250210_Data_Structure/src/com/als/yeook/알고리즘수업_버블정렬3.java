package 알고리즘;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 알고리즘수업_버블정렬3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] arrA = new int[n];
		int[] arrB = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		boolean isSame = true;
		for (int k = 0; k < n; k++) {
			if (arrA[k] != arrB[k]) {
				isSame = false;
				break;
			}
		}
		if (isSame) {
			bw.write("1");
			bw.flush();
			return;
		}

		for (int i = n - 1; i > 0; i--) {// 정렬할 위치 어차피 index 1이 정렬되면 0도 자동정렬됨.
			for (int j = 0; j < i; j++) {// 0번부터 수행
				if (arrA[j] > arrA[j + 1]) {
					int tmp = arrA[j];
					arrA[j] = arrA[j + 1];
					arrA[j + 1] = tmp;
					boolean isPossible = true;

					// 틀리면 둘이 굳이 비교할 필요 없음.
					if (arrA[j] == arrB[j] && arrA[j + 1] == arrB[j + 1]) {
						for (int k = 0; k < n; k++) {
							if (arrA[k] != arrB[k]) {
								isPossible = false;
								break;
							}
						}
						// 중간 비교시 같으면 1반환.
						if (isPossible) {
							bw.write("1");
							bw.flush();
							return;
						}
					}

				}
			}
			// 정렬된 것이 다르면 더이상 할 필요가 없음.
			if (arrA[i] != arrB[i]) {
				bw.write("0");
				bw.flush();
				return;
			}
		}
		// 다했는데도 다른경우
		bw.write("0");
		bw.flush();
	}
}
