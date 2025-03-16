package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1208_Flatten {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int cnt = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[100];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int check = 0, max = 0, min = 101, maxIdx = 0, minIdx = 0;
			while (check < cnt) {
				max = 0;
				min = 101;
				maxIdx = 0;
				minIdx = 0;
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] > max) {
						max = arr[i];
						maxIdx = i;
					}
					if (min > arr[i]) {
						min = arr[i];
						minIdx = i;
					}
				}
				arr[maxIdx]--;
				arr[minIdx]++;
				check++;
			}
			
			int lastMax = 0, lastMin =101;
			for (int i = 0; i < arr.length; i++) {
				lastMax = Math.max(arr[i], lastMax);
				lastMin = Math.min(arr[i], lastMin);
			}
			System.out.println("#" + tc + " " + (lastMax-lastMin));
		}
	}
}
