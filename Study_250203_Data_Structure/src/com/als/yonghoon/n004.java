package com.als.yonghoon;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class n004 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// box를 만들며 합 구하기
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n+1][n+1];
		int[][] sumArray = new int[n+1][n+1];
		int sum = 0;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = sc.nextInt();
				
				sum += arr[i][j];
				sumArray[i][j] = sum;
			}
		}
		
		// 0열 초기화
		for (int i  = 1; i <=n; i++) {
			sumArray[i][0] = sumArray[i-1][n];
		}
		
		for (int i = 0; i <m; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int total = 0;
			for (int j = x1; j <= x2; j++) { 	// 각 행
				total += sumArray[j][y2] - sumArray[j][y1-1];
			}
			
			bw.write(total + "");
			bw.write("\n");	
		}
		
		bw.flush();
		bw.close();
	}	
}