package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P036_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str = str.replaceAll("-", " - ").replaceAll("\\+", " + ");
		StringTokenizer st = new StringTokenizer(str);
		Queue<Character> oper = new LinkedList<Character>();
		Queue<Integer> num = new LinkedList<Integer>();
		num.add(Integer.parseInt(st.nextToken()));
		while(st.hasMoreTokens()) {
			oper.add(st.nextToken().charAt(0));
			num.add(Integer.parseInt(st.nextToken()));
		}
		int sum = 0;
		sum += num.poll();
		
		boolean bool = false;
		char tempOper = 0;
		int tempNum = 0;
		while(!num.isEmpty()) {
			tempOper = oper.poll();
			if(tempOper == '-') {
				if(bool) {
					sum -= tempNum;
					tempNum = 0;
				}
					tempNum += num.poll();
					bool = true;
			}else {
				if(bool) {
					tempNum += num.poll();
				}else {
					sum += num.poll();
				}
			}
		}
		sum -= tempNum;
		System.out.println(sum);
	}
}
