package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1954_달팽이_숫자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<= T; tc++) {
			int num = Integer.parseInt(br.readLine());
			int[][] snail = new int[num][num];
			
			int start = 1;
			int move = num;
			int dir = 1;
			int r = 0;
			int c= -1;
			
			
			while(start <= (num*num)) {
				for(int i=0; i<move;i++) {
					//수평이동
					c+=dir;
					snail[r][c] = start++; 
				}
				
				move--;
				
				for(int i=0; i<move; i++) {
					r+= dir;
					snail[r][c] = start++;
				}
				dir = -dir;

			}//
			
			System.out.println("#"+tc);
			for(int i=0; i<num; i++) {
				for(int j=0; j<num; j++) {
					System.out.print(snail[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
