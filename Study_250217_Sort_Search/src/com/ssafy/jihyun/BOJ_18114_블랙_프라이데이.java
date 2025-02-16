package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18114_블랙_프라이데이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] price = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
			if(price[i] == C) {
				System.out.println(1);
				return; //1개로 충족 여기서 종료
			}
		}
		Arrays.sort(price);
		
		//2개 & 3개일 때
		for(int i=0; i<N; i++) {
			int left = 1;
			int right = N-1;
			int target = C- price[i];
			
			while(left<right) {
				if(i==left) {
					left++;
					continue;
				}
				if(i==right) {
					right--;
					continue;
				}
				
				if(price[left] == target || price[right] == target || price[left] + price[right] == target) {
					System.out.println(1);
					return;
				}else if(price[left] + price[right] < target) {
					left++;
				}else {
					right--;
				}
			}
		}
		System.out.println(0);
	}
}