package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1204_최빈수_구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테스트케이스 수
		
		for(int tc=0; tc<T; tc++) {
			int num = Integer.parseInt(br.readLine()); //테스트케이스 번호
			int[] score = new int[101]; //점수는 0점~100점
			StringTokenizer st = new StringTokenizer(br.readLine()); //1000개 읽기
			for(int i=0; i<1000; i++) {
				score[Integer.parseInt(st.nextToken())]++;
			}
//			int[] len = {12, 15, 9, 12, 15, 9, 10, 10, 11, 11, 8, 10, 10, 15, 13, 7, 10, 8, 10, 10, 13, 15, 16, 7, 14, 10, 13, 2, 10, 8, 8, 8, 15, 12, 15, 13, 5, 3, 13, 12, 10, 15, 15, 9, 11, 10, 6, 12, 8, 11, 7, 13, 13, 9, 3, 11, 5, 7, 5, 11, 9, 9, 7, 10, 6, 10, 5, 15, 7, 11, 9, 17, 10, 9, 9, 5, 11, 12, 8, 7, 13, 10, 12, 9, 9, 6, 9, 8, 8, 5, 8, 6, 14, 7, 10, 12, 13, 9, 10, 8, 10};
//			System.out.println(len.length);
//			System.out.println(Arrays.toString(score));
//			System.out.println(score[100]);
//			System.out.println(score.length);
			int max = 0;
			int idx = 0;
			for(int i=100; i>=0; i--) {
				if(score[i]>max) {
					max = score[i];
					idx = i;
				}
			}
			System.out.println("#"+num+" "+idx);
		}
	}
}
