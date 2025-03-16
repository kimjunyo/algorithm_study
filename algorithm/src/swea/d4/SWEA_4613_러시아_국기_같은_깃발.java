package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4613_러시아_국기_같은_깃발 {
	static int N;
	static int M;
	static char[][] flag;
	static int[] num = new int[3];
	static int min;
	
	private static void findCombination(int depth) {
	    if (depth == 2) { 
	        int sum = 0;
	        for (int i = 0; i < num.length - 1; i++) {
	            sum += num[i];
	        }
	        if (N - sum >= 1) { 
	            num[2] = N - sum;
	            //System.out.println(Arrays.toString(num));
	            cal(num);
	        }
	        return;
	    }

	    for (int i = 1; i < N; i++) { 
	        num[depth] = i;
	        findCombination(depth + 1);
	    }
	}
	
	private static void cal(int[] num) {
		int white = num[0];
		int blue = num[1]+white;
		int red = num[2]+blue;
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				//System.out.print(flag[i][j]);
				if(i<white && flag[i][j] != 'W') cnt++;
				if(white <= i && i<blue && flag[i][j] != 'B') cnt++;
				if(blue <= i && i<red && flag[i][j] != 'R' ) cnt++;
			}
		}
		min = Math.min(cnt, min);
		//System.out.println(min);
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= T; tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			min = N*M;
			
			flag = new char[N][M];
			for(int i=0; i<N; i++) {
				String input = br.readLine();
				for(int j= 0; j<M; j++) {
					flag[i][j] = input.charAt(j);
				}
			}
			
			findCombination(0);
			System.out.println(sb.append(min));
			sb.setLength(0);
		}
	}//
}
