package com.ssafy.siyeong;

import java.util.Scanner;

public class 잃어버린괄호_1541_failed {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String tempStr = new String();
		int tempInt = 0;
		int res = 0;
		for (char c : str.toCharArray()) {
			if (c >= '0' && c <= '9') {
				tempStr += c;
			}
			else if (c == '-') {
				res -= Integer.parseInt(tempStr) + tempInt;
				tempStr = new String();
				tempInt = 0;
			}
			else {
				tempInt += Integer.parseInt(tempStr);
				tempStr = new String();
			}
			System.out.println("char = " + c + " tempStr = " + tempStr + " tempInt = " + tempInt + " res = " + res);
		}
		res -= Integer.parseInt(tempStr) + tempInt;
		System.out.println(res);
	}
}
