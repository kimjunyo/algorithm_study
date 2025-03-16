package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스_문제{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer> arr = new ArrayList<>();
		List<Integer> arr2 = new ArrayList<>();
		
		for(int i=1; i<N+1; i++) {
			arr.add(i);
		}
	
		int idx = M-1;
		arr.set(M-1,0);
		arr2.add(M);
		while(arr2.size() != N) {
			int check2 =0;
			while(check2 !=M) {
				if(arr.get((idx+1)%N) !=0) {
					check2++;
				}
				idx++;
			}
			idx %= N;
			arr2.add(arr.get(idx));
			arr.set(idx,0);
		}
		System.out.print("<");
		for(int i=0; i<arr2.size()-1; i++){
			System.out.print(arr2.get(i)+", ");
		}
		System.out.print(arr2.get(arr2.size()-1));
		System.out.print(">");
	}
}
