package com.als.yonghoon;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class n003 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int [] arr = new int[n+1];
		int [] sumArray = new int[n+1];
		int sum = 0;
		
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
			sumArray[i] = sum;
			
		}
		
		for (int i = 0; i <m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			bw.write((sumArray[b] - sumArray[a-1]) + "");
			bw.write("\n");
			
		}
		
		
		bw.flush();
		bw.close();
	}	
}