package 고층건물;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] buildings = new int[N + 1];
		int[] buildingsCount = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			int count = 0;

			outer:
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;

				if (i < j) {
					for (int k = i + 1; k < j; k++) {
						if (buildings[k] >= (buildings[j] - buildings[i]) * 1.0 / (j - i) * (k - j) + buildings[j]) {
							continue outer;
						}
					}
				} else {
					for (int k = j + 1; k < i; k++) {
						if (buildings[k] >= (buildings[i] - buildings[j]) * 1.0 / (i - j) * (k - j) + buildings[j]) {
							continue outer;
						}
					}
				}
				count++;
			}
			
			buildingsCount[i] = count;
		}
		
		int max = -1;
		for(int i=1; i<=N; i++) {
			if(max < buildingsCount[i]) {
				max = buildingsCount[i];
			}
		}
		
		System.out.println(max);
	}
}
