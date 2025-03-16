package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//테케수
//과제수(N) A팀 할당(W1) B팀할당(W2)
//N배열 

public class IM대비4_최소비용 {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int W1 = Integer.parseInt(st.nextToken());
			int W2 = Integer.parseInt(st.nextToken());
			int[] work = new int[N];
			int cnt =0;
			for(cnt=0; cnt<W1; cnt++) work[cnt] = (cnt+1);
			for(int i=0; i<W2;i++) work[cnt++] = (i+1);
			Arrays.sort(work);
			
			int[] lv = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) lv[i] = Integer.parseInt(st.nextToken());

			Arrays.sort(lv);
			
			int sum = 0;
			for(int i=0, j=N-1; i<N&&j>=0; i++, j--) sum+= work[i] * lv[j];
			
			System.out.println("#"+tc+" "+sum);
		}// 테케괄호
	}
}
