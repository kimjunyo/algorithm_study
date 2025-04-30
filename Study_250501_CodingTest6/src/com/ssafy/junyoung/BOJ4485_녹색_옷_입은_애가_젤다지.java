import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main
{
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Node {
		int row, col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
	}
	public static void main(String args[]) throws Exception
	{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 StringBuilder sb = new StringBuilder();
		 int N = Integer.parseInt(br.readLine());
		 int problem = 1;
		 while(N != 0) {
			 int[][] arr = new int[N][N];
			 boolean[][] visited = new boolean[N][N];
			 int[][] dist = new int[N][N];
			 for(int i=0; i<N; i++) {
				 StringTokenizer st = new StringTokenizer(br.readLine());
				 for(int j=0; j<N; j++) {
					 arr[i][j] = Integer.parseInt(st.nextToken());
					 dist[i][j] = Integer.MAX_VALUE;
				 }
			 }
			 
			 visited[0][0] = true;
			 
			 Queue<int[]> queue = new ArrayDeque<>();
			 queue.offer(new int[] {0, 0});
			 dist[0][0] = arr[0][0];
			 
			 while(!queue.isEmpty()) {
				 int[] input = queue.poll();
				 for(int i=0; i<4; i++) {
					 int nr = input[0] + dr[i];
					 int nc = input[1] + dc[i];
					 
					 if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					 if(dist[nr][nc] > dist[input[0]][input[1]] + arr[nr][nc]) {
						 dist[nr][nc] = dist[input[0]][input[1]] + arr[nr][nc];
						 queue.offer(new int[] {nr, nc});
					 }
				 }
			 }
			 sb.append("Problem ").append(problem).append(": ").append(dist[N-1][N-1]).append("\n");
			 
			 
			 N = Integer.parseInt(br.readLine());
			 problem++;
		 }
		 
		 bw.write(sb.toString());
		 bw.flush();
	}
}
