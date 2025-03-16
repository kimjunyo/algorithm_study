package swea.d1;
import java.util.Scanner;

public class SWEA_20397_돌_뒤집기_게임2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<= T ; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] rock = new int[N+1];
			for(int i=1; i<N+1; i++) {
				rock[i] = sc.nextInt();
			}
			
			for(int i=0; i<M; i++) {
				int I = sc.nextInt();
				int J = sc.nextInt();
				int d = 1;
				while(d<=J) {
					if(0<I-d && I-d<=N && 0<I+d && I+d<=N ) {
						if(rock[I-d] == rock[I+d]) rock[I-d] = rock[I+d] =(rock[I-d]+1) % 2;
					}
					d++;
				}
			}
			System.out.print("#" + tc);
			for(int i=1; i<N+1; i++) {
				System.out.print(" "+rock[i]);
			}
			 System.out.println();
		}
	}
}
