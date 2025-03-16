package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_1972_놀라운_문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<>();
		
		while(true) {
			boolean isSurprising = true;
			String input = br.readLine();
			
			if(input.equals("*")) return;
			
			int len = input.length(); 
			int check = 1;
			
			breakPoint:
			while(check<len) {
				set.clear();
				for(int i=0; i<len-check; i++) {
					String str = ""+input.charAt(i)+input.charAt(i+check);
					
					if(!set.add(str)) {
						isSurprising = false;
						break breakPoint;
					}
				}
				check++;
			}
			if(isSurprising) System.out.println(input + " is surprising.");
			else System.out.println(input + " is NOT surprising.");
		}
	}
}
