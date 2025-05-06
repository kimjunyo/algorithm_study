import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] sumArr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			sumArr[i] = sumArr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int left = 1, right = 1;
		int result = Integer.MAX_VALUE;
		while(right<=N) {
			int sum = sumArr[right] - sumArr[left-1];
			
			if(sum >= S) {
				result = Math.min(result, right-left+1);
				left++;
			}
			else right++;
		}
		
		if(result != Integer.MAX_VALUE) System.out.println(result);
		else System.out.println(0);
	}
}
