package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001_파리퇴치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); //배열 크기
			int N = Integer.parseInt(st.nextToken()); //파리채 크기
			int[][] fly = new int[M+1][M+1];
			
			for(int i=1; i<=M; i++) { //배열 받고
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=M; j++) {
					fly[i][j] = Integer.parseInt(st.nextToken());					
				}
			}
			
			int[][] sumFly = new int[M+1][M+1];
			for(int i=1; i<=M; i++) { //누적합 만들기
				for(int j=1; j<=M; j++) {
					sumFly[i][j] = sumFly[i][j-1] + sumFly[i-1][j] - sumFly[i-1][j-1] + fly[i][j];				
				}
			}
			int max = 0;
			for(int i = N; i<=M;i++) { 
				for(int j=N; j<=M; j++) {
					int check = sumFly[i][j] - sumFly[i-N][j] - sumFly[i][j-N] + sumFly[i-N][j-N];
					max = Math.max(max, check);
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}

//import java.util.Scanner;
//
//public class Solution{
//    public static void main(String args[]){
//        
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        
//        for (int test_case = 1; test_case <= T; test_case++){
//            
//            int N = sc.nextInt();
//            int M = sc.nextInt();
//            int[][] A = new int[N][N];
//            
//            for(int i=0;i<N;i++){
//                for(int j=0;j<N;j++){
//                    A[i][j] = sc.nextInt();
//                }
//            }
//            
//            int result = 0;
//            for(int i=0; i<N-M+1;i++){
//                for(int j=0; j<N-M+1;j++){
//                    int sum = 0;
//                    
//                    for(int k=0; k<M;k++){
//                        for(int l=0; l<M; l++){
//                            sum += A[i+k][j+l];
//                        }
//                    }
//                    result = Math.max(result,sum);
//                }
//            }           
//            System.out.println("#"+test_case+" "+result);           
//        }
//        sc.close();
//    }
//}
