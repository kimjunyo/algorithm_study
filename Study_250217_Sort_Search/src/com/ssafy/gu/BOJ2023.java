import java.util.Scanner;

public class BOJ2023 {
	static Scanner sc;
	static int N;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		
		DFS(2,1);
		DFS(3,1);
		DFS(5,1);
		DFS(7,1);
	}
	
	
	static void DFS(int prime, int jarisu) {
		if (jarisu == N) {
			System.out.println(prime);
			return;
		}
		for (int i = 1; i < 10; i+=2) {
			if (isPrime(prime * 10 + i)) {
				DFS(prime * 10 + i, jarisu+1);
			}
		}
	}
	
	
	static boolean isPrime(int n) {
		for (int i = 2; i <= n/2; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
}
