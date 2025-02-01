package com.als.yonghoon;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class n001 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		int total = 0;
		
		for (int i = 0; i <str.length(); i++) {
			total += str.charAt(i) - '0';
		}
		
		bw.write(total + "");
		
		bw.flush();
		bw.close();
	}	
}
