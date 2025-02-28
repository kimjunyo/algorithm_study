package com.ssafy.siyeong;

import java.util.Scanner;

public class 잃어버린괄호_1541 {
	
	private static int strSum(String str) {
		int temp = 0;
		//정규식표현 뭐시기때문에 "+"로 하면 안됨
		String[] strArr = str.split("\\+");
		for (String s : strArr) {
			temp += Integer.parseInt(s);
		}
		return temp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strArr = str.split("-");
		int res = 0;
		res += strSum(strArr[0]);
		for (int i = 1; i < strArr.length; i++) {
			res -= strSum(strArr[i]);
		}
		System.out.println(res);
	}
}
