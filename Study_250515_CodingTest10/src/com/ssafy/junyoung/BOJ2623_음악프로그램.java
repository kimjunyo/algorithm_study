import java.util.*;
import java.io.*;

public class Main {
  static List<Integer>[] adj;
  static int[] pos;
  static int N;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    adj = new ArrayList[N+1];
    pos = new int[N+1];

    for(int i=1; i<=N; i++) {
      adj[i] = new ArrayList<>();
    }

    for(int i=1; i<=M; i++) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      
      int first = Integer.parseInt(st.nextToken());
      int second = 0;
      for(int j=0; j<num-1; j++) {
        second = Integer.parseInt(st.nextToken());

        adj[first].add(second);
        pos[second]++;
        first = second;
      }
    }

    Queue<Integer> queue = new ArrayDeque<>();

    for(int i=1; i<=N; i++) {
      if(pos[i] == 0) queue.offer(i);
    }
    StringBuilder sb = new StringBuilder();
    int count = 0;

    while(!queue.isEmpty()) {
      int node = queue.poll();
      sb.append(node).append("\n");
      count++;
      for(int i=0; i<adj[node].size(); i++) {
        int next = adj[node].get(i);
        pos[next]--;
        if(pos[next] == 0) {
          queue.offer(next);
        }
      }
    }
    
    if(count == N) {
    	bw.write(sb.toString());
    } else {
    	bw.write("0");
    }
    
    bw.flush();
  }
}
