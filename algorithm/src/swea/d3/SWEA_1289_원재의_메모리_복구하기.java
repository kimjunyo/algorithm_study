package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1289_원재의_메모리_복구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		//int T = Integer.parseInt(sc.nextLine());
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#" + tc + " ");
//			String input = sc.nextLine();
			String input = br.readLine();
			int cnt = 0;
			int prev = input.charAt(0)-'0';
			if(prev==1) cnt++;
			
			for(int i=1; i<input.length(); i++) {
				int curr = input.charAt(i)-'0';
				if(prev !=curr) cnt++;
				
				prev = curr;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
