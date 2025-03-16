package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//N: 배열크기
//M : 스프레이 강도

public class SWEA_12712_파리퇴치3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			
			//배열 입력 받기
			int[][] field = new int[N][N];
			for(int r = 0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c<N; c++) {
					field[r][c] = Integer.parseInt(st.nextToken());
				}
			}
//			System.out.println(Arrays.deepToString(field));
			
			int cnt = 0, cnt1 = 0, cnt2 = 0, maxCnt = 0;
			//동서남북 2,5,7,11시 방향
			int[] row = {0,0,1,-1, -1,+1,+1,-1};
			int[] col = {1,-1,0,0, 1, 1,-1, -1};
			
			//탐색
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					cnt1 = 0; cnt2 = 0;			
					//십자가
					for(int dir = 0; dir<4; dir++) {
						for(int p = 1; p<M; p++) {
							int cRow = row[dir]*p + r;
							int cCol = col[dir]*p + c;
							
							if(0<=cRow && cRow<N && 0<=cCol && cCol<N) {
								cnt1 += field[cRow][cCol];
							}
						}
					}
					cnt1 += field[r][c];
					//System.out.println("cnt1 :::"+cnt1);
					
					//엑스자
					for(int dir = 4; dir<8; dir++) {
						for(int p = 1; p<M; p++) {
							int cRow = row[dir]*p + r;
							int cCol = col[dir]*p + c;
							
							if(0<=cRow && cRow<N && 0<=cCol && cCol<N) {
								cnt2 += field[cRow][cCol];
							}
						}
					}
					cnt2 += field[r][c];
					//System.out.println("cnt2 :::"+cnt2);
					cnt = cnt1>cnt2 ? cnt1 : cnt2;
					//System.out.println("cnt :::"+cnt);
					maxCnt = cnt > maxCnt ? cnt : maxCnt;
					//System.out.println("maxCnt :::"+maxCnt);
					
				}
			}
			
			
			System.out.println("#"+tc+" "+maxCnt);
		}
	}

}
