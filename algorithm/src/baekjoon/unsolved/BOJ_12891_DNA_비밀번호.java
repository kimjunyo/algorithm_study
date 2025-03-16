package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// A C G T

public class BOJ_12891_DNA_비밀번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());  //9
		int P = Integer.parseInt(st.nextToken());  //8
		
		String input = br.readLine();
		int[] must = new int[4];
		int[] check = new int[4]; // A C G T
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			must[i] = Integer.parseInt(st.nextToken());
		}
		//첫번째 검사
		for(int i=0; i< P; i++) {
			if(input.charAt(i)=='A') check[0]++;
			else if(input.charAt(i)=='C') check[1]++;
			else if(input.charAt(i)=='G') check[2]++;
			else check[3]++;  // T일 때
		}

		// 이 과정을 언제까지? 몇번?
		//두번째 검사
		for(int i=1; i< P+1; i++) {
			if(input.charAt(i)=='A') check[0]++;
			else if(input.charAt(i)=='C') check[1]++;
			else if(input.charAt(i)=='G') check[2]++;
			else check[3]++;  // T일 때
		}
		
		for(int i=0; i<P-S; i++) {
			
			
			
			
			
			
		}
		
		
//		for(int i=0; i<input.length(); i++) {
//			if(input.charAt(i)=='A') check[0]++;
//			else if(input.charAt(i)=='C') check[1]++;
//			else if(input.charAt(i)=='G') check[2]++;
//			else check[3]++;  // T일 때
//		}
//		
//		for(int i=0; i< S-P+1; i++) { //2번 검사함
//			
//			
//			
//		}
	}
	

}
