package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1244_스위치_켜고_끄기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[Integer.parseInt(br.readLine()) + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = Integer.parseInt(br.readLine());
		for (int i = 1; i <= cnt; i++) {
			st = new StringTokenizer(br.readLine());
			if (Integer.parseInt(st.nextToken()) == 1) { // 남자
				int m = Integer.parseInt(st.nextToken());
				for (int j = m; j < arr.length; j += m) {
				    arr[j] = (arr[j] + 1) % 2;
				}
			} else { // 여자
				int m = Integer.parseInt(st.nextToken());
				if(1<m && m<arr.length-1 && arr[m-1]== arr[m+1]) {
					int left = m - 1;
					int right = m + 1;
					while (left >= 1 && right < arr.length && arr[left] == arr[right]) {
					    left--;
					    right++;
					}
					for (int j = left + 1; j < right; j++) {
					    arr[j] = (arr[j] + 1) % 2;
					}
				}else {
					arr[m] = (arr[m] + 1) % 2;
				}
			}
		}
		for (int i = 1; i < arr.length; i++) {
		    System.out.print(arr[i] + " ");
		    if (i % 20 == 0) {
		        System.out.println();
		    }
		}
	}
}
