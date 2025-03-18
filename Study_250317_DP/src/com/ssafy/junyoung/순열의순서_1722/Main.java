package 순열의순서;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] factorials;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		factorials = new long[21];
		visited = new boolean[21];
		factorials[0] = 1;
		
		for (int i = 1; i <= 20; i++) {
		    factorials[i] = factorials[i - 1] * i;
		}
		
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		

		String selection = st.nextToken();
		switch (selection) {
		case "1":
			long k = Long.parseLong(st.nextToken());
			k--;
			
			StringBuilder sb = new StringBuilder();

			for (int i = N-1; i >=0 ; i--) {
				long mul = k / factorials[i];
				int count = 0;
				
				for (int j = 1; j <= N; j++) {
					// 이미 방문한 숫자면 다음
					if(visited[j]) {
						continue;
					}
					
					// 수가 같으면 그 때 방문을 기록하고 순서 더하기
					if(mul == count) {
						visited[j] = true;
						sb.append(j).append(" ");
						break;
					}
					count++;
				}
				
				k = k % factorials[i];
			}
			
			System.out.println(sb);
			break;
		case "2":
			
			long order = 0;
			for (int i = N-1; i >=0 ; i--) {
				int num = Integer.parseInt(st.nextToken());
				int mul = 0;
				
				for (int j = 1; j <= N; j++) {
					// 이미 방문한 숫자면 다음
					if(visited[j]) {
						continue;
					}
					
					// 수가 같으면 그 때 방문을 기록하고 순서 더하기
					if(num == j) {
						visited[j] = true;
						order += factorials[i] * mul;
						break;
					}
					mul++;
				}
			}

			System.out.println(order + 1);
		}
	}
}