package com.als.yeook;
import java.util.*;
import java.io.*;

//슬라이딩 윈도우를 ArrayList로 만들어서 했더니 add메서드가 시간복잡도n이라 시간초과남.
public class DNA비밀번호_S12891 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		//주어진 문자열 배열로 저장.
		char []arr = new char[n];
		String str = new StringTokenizer(br.readLine()).nextToken();
	
		for(int i=0;i<n;i++) {
			arr[i]=str.charAt(i);
		}
		
		int total = 0;
		//현재 윈도우의 ACGT 갯수.
		int[]curCount = new int [4]; 
		//주어진 조건의 ACGT 갯수.
		int[] minimunCount = new int [4]; 
		 st = new StringTokenizer(br.readLine());
		 for(int i = 0;i<4;i++) {
			 minimunCount[i]=Integer.parseInt(st.nextToken());
		 }

		 int start = 0;
		 int end=m-1;
		for(int i = 0;i<m;i++) {
			curCount=addcount(arr[i], curCount);
		}
		 
		 for(int i = end;i<arr.length;i++) {
			 boolean isPossible=true;
			 for(int j = 0;j<4;j++) {
				 if(curCount[j]<minimunCount[j]) {
					 isPossible=false;
					 break;
					 }
			 }
			 if(isPossible)total++;
			 if(i==arr.length-1)break;
			 end++;

			 char c = arr[end];
			 curCount=removecount(arr[start],curCount);
			 start++;
			 curCount=addcount(arr[end],curCount);
			 
		}

		bw.write(String.valueOf(total));
		bw.flush();
	}
	//추가할 문자열카운트세기 
	public static int[] addcount(char c,int[] curCount) {
		 if(c=='A') {
			 curCount[0]++;
		 }else if(c=='C') {
			 curCount[1]++;
		 }else if(c=='G') {
			 curCount[2]++;
		 }else if (c=='T') {
			 curCount[3]++;
		 }
		 return curCount;
	}
	public static int[] removecount(char c,int[] curCount) {
		 if(c=='A') {
			 curCount[0]--;
		 }else if(c=='C') {
			 curCount[1]--;
		 }else if(c=='G') {
			 curCount[2]--;
		 }else if (c=='T') {
			 curCount[3]--;
		 }
		 return curCount;
	}

}
