package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최솟값_10868 {
	static int n,m,k;
	static long[] arr, tree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //전체 숫자의 갯수  
		m = Integer.parseInt(st.nextToken()); // 구간의 최솟값 구하는 수.
		
		arr = new long[n+1]; //주어진 숫자 저장.
		for(int i = 1;i<=n;i++) {
			arr[i]=Long.parseLong(new StringTokenizer(br.readLine()).nextToken());
		}
		
		tree = new long[n*4+1];
		recur(1,n,1);
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int left =  Integer.parseInt(st.nextToken()); 
			int right =  Integer.parseInt(st.nextToken()); 
			result.append(find(1,n,1,left,right)).append("\n");
		}
		System.out.println(result);

	}
	public static long recur(int start, int end, int index) {
		if(start==end) {
			return tree[index]=arr[start];
			
		}
		int mid = (start+end)/2;
	return	tree[index] =Math.min(recur(start,mid, index*2),recur(mid+1,end,index*2+1));
	}
	
	public static long find( int start, int end, int index,int left, int right) {
		if (right < start || end < left) {
			return Long.MAX_VALUE;
		}
		if (left <= start && end <= right) {
			return tree[index];
		}
		int mid = (start + end) / 2;
		return Math.min(find( start, mid,index*2, left, right),find( mid + 1, end, index*2+1,left, right));
	}
}
