import java.io.*;
import java.util.*;
 
public class BOJ_18428_감시피하기 {
   static char[][] board;
   static boolean ANSWER;
   static int N;
   static ArrayList<int[]> teacher;
   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(in.readLine());
      StringTokenizer st;
      board = new char[N][N];
      teacher = new ArrayList<>();
      for(int i=0;i<N;i++){
         st = new StringTokenizer(in.readLine());
         for(int j=0;j<N;j++){
            board[i][j] = st.nextToken().charAt(0);
            if(board[i][j]=='T') teacher.add(new int[]{i,j});
         }
      }
 
      pick(0,0,0);
 
      if(ANSWER) System.out.println("YES");
      else System.out.println("NO");
   }
 
   private static void pick(int cnt, int i, int j){
      if(ANSWER) return;
      if(cnt==3){
         ANSWER = check();
         return;
      }
 
      int nj;
      for(int ni=i;ni<N;ni++){
         if(ni==i) nj = j+1;
         else nj = 0;
         for(;nj<N;nj++){
            if(board[ni][nj]=='X'){
               board[ni][nj]='O';
               pick(cnt+1, ni, nj);
               board[ni][nj] = 'X';
            }
         }
      }
   }
 
   private static boolean check(){
      int[][] deltas = {{1,0},{0,1},{0,-1},{-1,0}};
      int ni,nj;
      for(int[] t:teacher){
         for(int[] d:deltas){
            ni = t[0];
            nj = t[1];
            while(true){
               ni += d[0];
               nj += d[1];
               if(ni<0 || ni>=N || nj<0 || nj>=N) break;
               if(board[ni][nj]=='S') return false;
               else if(board[ni][nj]=='O') break;
            }
         }
      }
 
      return true;
   }
}
