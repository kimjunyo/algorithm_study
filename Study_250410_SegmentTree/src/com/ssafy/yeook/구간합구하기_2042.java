package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기_2042 {
	static int n,m,k;
	static long[] arr, tree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //전체 숫자의 갯수  
		m = Integer.parseInt(st.nextToken()); // 변경일어나는수.
		k = Integer.parseInt(st.nextToken()); // 구간합 구하는 수.
		
		arr = new long[n+1]; //주어진 숫자 저장.
		for(int i = 1;i<=n;i++) {
			arr[i]=Long.parseLong(new StringTokenizer(br.readLine()).nextToken());
		}
		
		 tree = new long[n*4+1];
		 recur(1,n,1);
		
		
		int mk = m+k;
		for(int i = 0;i<mk;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			//바꾸기
			if(a==1) {
				int targetIndex = Integer.parseInt(st.nextToken());
				long num = 	Long.parseLong(st.nextToken());
				change(1,n,1,targetIndex,num);
			//구간합 구하기 
			}else {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				result.append(sum(1,n,1,left,right)).append("\n");
			}
		}
		System.out.println(result);
		
	}
	public static long recur(int start, int end, int index) {
		if(start==end) {
			return tree[index]=arr[start];
			
		}
		int mid = (start+end)/2;
	return	tree[index] = recur(start,mid, index*2)+ recur(mid+1,end,index*2+1);
	}
	public static void change(int start, int end, int index, int targetIndex, long num) {
		if(start==end){
			tree[index] = num;
			return;
		}
		int mid = (start+end)/2;
		if(mid>=targetIndex) 
			change(start, mid,index*2,targetIndex,num);
		else 
			change(mid+1, end,index*2+1,targetIndex,num);
		
		tree[index] = tree[index*2]+tree[index*2+1];
		
	}
	public static long sum( int start, int end, int index,int left, int right) {
		if (right < start || end < left) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[index];
		}
		int mid = (start + end) / 2;
		return sum( start, mid,index*2, left, right) + sum( mid + 1, end, index*2+1,left, right);
	}
	
}
