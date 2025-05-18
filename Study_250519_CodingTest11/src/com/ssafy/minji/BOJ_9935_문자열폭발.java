package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935_문자열폭발 {
	static String str;
	static String exp;
	static Stack<Character> stk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().trim();
		exp = br.readLine().trim();
		stk = new Stack<>();
		char lastCh = exp.charAt(exp.length() - 1);
		char ch;
		for(int i = 0 ; i < str.length() ; i++) {
			ch = str.charAt(i);
			stk.push(ch);
			
			if(ch == lastCh && stk.size() >= exp.length()) {
				push = false;
				check(exp.length() - 1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(char c : stk) {
			sb.append(c);
		}
		
		if(sb.length() == 0) {
			System.out.println("FRULA");
		}else {
			System.out.println(sb);
		}
		
	}
	
	static Stack<Character> temp = new Stack<>();
	static boolean push = false;
	static void check(int idx) {
		if(idx < 0) {
			push = true;
			temp.clear();
			return;
		}
		
		char expCh = exp.charAt(idx);
		char strCh = stk.peek();
		if(expCh == strCh) {
			temp.add(stk.pop());
			check(idx - 1);
		}else {
			return;
		}
		
		// check 재귀 도중 폭발문자열과 같지 않아서 돌아왔다 : stack에 다시 집어넣는다
		if(!push) {
			stk.push(temp.pop());
		}
	}
}
