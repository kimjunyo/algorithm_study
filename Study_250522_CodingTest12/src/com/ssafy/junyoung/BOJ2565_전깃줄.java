import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
        
		int[] dp = new int[N];	
		int[][] wire = new int[N][2];
		
		StringTokenizer st;
		for(int i = 0; i < wire.length; i++) {
			st = new StringTokenizer(br.readLine()," ");
			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(wire, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
 
		for(int i = 0; i < dp.length; i++) {
			
			dp[i] = 1;
			
			for(int j = 0; j < i; j++) {
				if(wire[i][1] > wire[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		// 전체 개수 - 설치 가능한 전깃줄 = 최소 철거 개수 
		System.out.println(N - max);
		
	}
 
}
