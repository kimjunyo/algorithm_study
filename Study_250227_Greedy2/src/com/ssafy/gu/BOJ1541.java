package com.ssafy.gu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean isMinus = false;
		int plusSum = 0;
		int minusSum = 0;
		int totalSum = 0;
		while (true) {
			int i = br.read();
			if (i == 10) {
				int num = Integer.parseInt(sb.toString());
				if (!isMinus) plusSum += num;
				else minusSum += num;
				break;
			}
			if (i >= '0' && i <= '9') {
				sb.append(String.valueOf(i-'0'));
			} else if (i == '+') {
				int num = Integer.parseInt(sb.toString());
				sb.delete(0, sb.length());
				if (!isMinus) plusSum += num;
				else minusSum += num;
			} else if (i == '-') {
				int num = Integer.parseInt(sb.toString());
				sb.delete(0, sb.length());
				if (!isMinus) plusSum += num;
				else minusSum += num;
				totalSum -= minusSum;
				minusSum = 0;
				isMinus = true;
			}
		}
		
		System.out.println(totalSum+plusSum-minusSum);
	}
}
