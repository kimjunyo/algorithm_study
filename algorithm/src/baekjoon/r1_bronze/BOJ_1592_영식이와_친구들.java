package baekjoon.r1_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1592_영식이와_친구들 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[Integer.parseInt(st.nextToken())+1];
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); //num칸씩 이동
		int len = arr.length-1;
		int cnt = 0;
		int idx =1;		
		arr[idx]++;
		
		if(N ==1) {
			System.out.println(0);
		}else {
			while(true) {
				if(arr[idx] %2 != 0) { //홀수
					idx = (idx+M) <= len ? idx+M : idx+M-len; 
					cnt++;
					arr[idx]++;
					if(arr[idx]==N) break;
				}else { //짝수
					idx = (idx-M) >0 ? idx-M : idx-M+len;
					cnt++;
					arr[idx]++;
					if(arr[idx]==N) break;
				}
			}
			System.out.println(cnt);
		}
	}
}
