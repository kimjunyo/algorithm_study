package swea.d1;

import java.util.Scanner;

public class SWEA_2058_자릿수더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int sum =0;
		for(int i=0; i<input.length(); i++) {
			sum += input.charAt(i)-'0';
		}
		System.out.println(sum);
	}
}
