package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477_참외밭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		int K = Integer.parseInt(br.readLine());
		int[] dir = new int[6];
		int[] len = new int[6];
		int[] arr = new int[4]; // 최대 가로 세로// 나머지 가로 세로

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			dir[i] = Integer.parseInt(st.nextToken());
			len[i] = Integer.parseInt(st.nextToken());
			if (dir[i] == 1 || dir[i] == 2) { // 동서(1,2)방향-> 가로
				arr[0] = Math.max(len[i], arr[0]);
			} else { // 남북방향(3,4) -> 세로
				arr[1] = Math.max(len[i], arr[1]);
			}
		}

		for (int i = 0; i < 6; i++) { 
		    if (dir[i] == dir[(i + 2) % 6] && dir[(i + 1) % 6] ==dir[(i + 3) % 6]) { 
		        arr[2] = len[(i + 1) % 6];
		        arr[3] = len[(i + 2) % 6];
		        break;
		    }
		}
		System.out.println((arr[0] * arr[1] - arr[2] * arr[3]) * K);
	}

}
