package baekjoon.r1_bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2292_벌집 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input =Integer.parseInt(br.readLine());
		int num =1;
		int sum =1;
		
		while(sum<input) {
			sum += 6*num;
			num++;
		}
		System.out.println(num);
	}
}
