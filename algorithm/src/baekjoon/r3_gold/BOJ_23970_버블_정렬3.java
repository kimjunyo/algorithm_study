package baekjoon.r3_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_23970_버블_정렬3 {
	
	static int BubbleSort(int[] A, int[] B) {
		for (int i = 0; i < A.length - 1; i++) {
			boolean check = false;
			
			for (int j = 0; j < A.length - 1 - i; j++) {
				if (A[j] > A[j + 1]) {
					int tmp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = tmp;
					check = true;
					
					if (A[j] == B[j]  && Arrays.equals(A, B)) {
						return 1;
					}
				}
				
			}
			if(!check) break;
		}
		return 0; 
	}

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		int[] B = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		if(Arrays.equals(A, B)) {
			System.out.println(1);
			return;
		}else {
			System.out.println(BubbleSort(A,B));
		}
	}
}
