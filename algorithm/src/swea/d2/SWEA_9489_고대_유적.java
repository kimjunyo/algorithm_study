package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9489_고대_유적 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
//		for(int tc = 1; tc <= T; tc++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int N = Integer.parseInt(st.nextToken());
//			int M = Integer.parseInt(st.nextToken());
//			
//			int[][] arr = new int[N][M];
//			
//			for(int i=0; i<N; i++) {
//				st = new StringTokenizer(br.readLine());
//				for(int j=0; j<M; j++) {
//					arr[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
//			
//			//동 남
//			int[] row = {0, 1};
//			int[] col = {1, 0};
//			int cnt = 0;
//			int max = 0;
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					if(arr[i][j] ==1) {
//						for(int d = 0; d<2; d++) { //동 남
//							for(int m = 1; m<8; m++) { //이동
//								int cRow = i + row[d]*m;
//								int cCol = j + col[d]*m;
//								
//								if(0<= cRow && cRow <N && 0<= cCol && cCol <M) {
//									if(arr[cRow][cCol] == 1) {
//										cnt++;
//									}else {
//										break;
//									}
//									max = Math.max(max, cnt);
//								}
//							}
//						}
//					}
//				}
//			}
//			System.out.println("#" +tc + " " + max);
//			
//		}//
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//동 남
			int max = 0;
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j] ==1) {
						cnt =1;
						//동쪽
						for(int d=1; d<M-j; d++) {
							if(arr[i][j+d]==1) {
								cnt++;
							}else {
								break;
							}
						}
						max = Math.max(cnt, max);
						cnt = 1;
						//남쪽
						for(int d=1; d<N-i; d++) {
							if(arr[i+d][j]==1) {
								cnt++;
							} else {
								break;
							}
						}
						max = Math.max(cnt, max);
					}
				}
			}
			System.out.println("#" +tc + " " + max);
		}//
	}//
}
