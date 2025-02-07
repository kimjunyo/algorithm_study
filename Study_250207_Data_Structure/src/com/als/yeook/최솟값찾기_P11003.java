package com.als.yeook;

import java.io.*;
import java.util.*;

public class 최솟값찾기_P11003 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int []arr = new int[n];
		st = new StringTokenizer(br.readLine());
		//n개의 수 저장 
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		StringBuilder result = new StringBuilder();
		Deque<int[]> deque=new ArrayDeque<>();//{index,num}
		
		for(int i=0;i<n;i++) {
			int num=arr[i];
			//덱의 첫번째 요소가 윈도우의 범위를 벗어난 경우 제거함.
			if(deque.size()>0&&deque.getFirst()[0]<=i-m) {
				deque.pollFirst();
			}
			
			while(deque.size()>0) {
				if(deque.getLast()[1]>num) {
					deque.pollLast();
				}else {
					break;
				}
			}
			//덱에 아무리 많이 저장되어도m-1개만 저장됨.(위에서 변경된 윈도우의 위치에 따라 벗어난것을 빼주니까.)
			deque.addLast(new int[] {i,num});
			result.append(deque.getFirst()[1]).append(" ");
		}
		
		bw.write(result.toString().trim());
		bw.flush();
		
	}

}

