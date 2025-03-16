package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 싸피캠퍼스야경LED {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) { //1 1 0 0 1
				arr[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(arr));
			int cnt = 0;
			for(int i=1; i<N; i+=i) {
				if(arr[i] == 1) {
					arr[i] = 0;
					cnt++;
				}
			}
			System.out.println("#"+tc+" "+(cnt+1));
		}//
	}

}
