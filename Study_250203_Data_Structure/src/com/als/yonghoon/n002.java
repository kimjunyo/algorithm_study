package com.als.yonghoon;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class n002 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = sc.nextInt();
		double [] arr = new double[num];
		double total = 0;
		double max = 0;
		
		
		for (int i = 0; i <num; i++) {
			arr[i] = sc.nextInt();
			max = (max <arr[i]) ? arr[i] : max;
		}
		
		for (int i = 0; i <num; i++) {
			total += (arr[i]/max)*100;
		}
		
		bw.write((total/num) + "");
		
		bw.flush();
		bw.close();
	}	
}
