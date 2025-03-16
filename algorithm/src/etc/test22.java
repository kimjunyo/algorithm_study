package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class test22 {
	public static void main(String[] args) throws IOException {
		Set<String> set = new HashSet<>();
		String input = "BCBABCC";
		String result = ""+input.charAt(1) + input.charAt(3);
		System.out.println(result);
		set.add(("input.charAt(i)"+"input.charAt(i+check)"));	
		
		System.out.println(set);
	}
}
