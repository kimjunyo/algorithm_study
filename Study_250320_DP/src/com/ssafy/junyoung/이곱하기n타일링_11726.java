package 이곱하기n타일링_11726;

import java.util.Scanner;

public class 이곱하기n타일링_11726 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		int[] arr = new int[N+1];
		arr[1] = 1;
		if(N >= 2) {
			arr[2] = 2;			
		}
		
		for(int i=3; i<=N; i++) {
			arr[i] = (arr[i-1] + arr[i-2]) % 10_007;
		}
		
		System.out.println(arr[N]);
		scan.close();
	}
}
