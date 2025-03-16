package baekjoon.r3_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253_좋다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0, right = 0, cnt = 0, len = 0;
		for(int i=0; i<N; i++) {
			int target = arr[i];
			left = 0; right = N-1; //idx
			while(left<right) {
				
				if (left == i) {
					left++;
					continue;
				}
				if (right == i) {
					right--;
					continue;
				}
				
				if(arr[left]+arr[right]==target) {
					cnt++;
					break;
				}else if(arr[left]+arr[right]<target) {
					left++;
				}else {
					right--;
				}
			}
		}
		System.out.println(cnt);
	}
}