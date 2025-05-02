import java.util.*;
import java.io.*;

public class Main {
  static int[] parent;
  static int V;
  static class Node implements Comparable<Node> {
    int start, end, value;

    Node(int start, int end, int value) {
      this.start = start;
      this.end = end;
      this.value = value;
    }

    @Override
    public int compareTo(Node o) {
      return this.value - o.value;
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    parent = new int[V+1];

    for(int i=1; i<=V; i++) {
      parent[i] = i;
    }

    PriorityQueue<Node> pq = new PriorityQueue<>();

    for(int i=0; i<E; i++) {
      st = new StringTokenizer(br.readLine());
      int first = Integer.parseInt(st.nextToken());
      int second = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());

      pq.offer(new Node(first, second, value));
    }
    boolean[] visited = new boolean[V+1];
    int count = 0;
    long sum = 0;

    while(!pq.isEmpty()) {
      Node node = pq.poll();
      if(find(node.start) != find(node.end)) {
        union(node.start, node.end);
        sum += node.value;
        count ++;
      }

      if(count == V-1) {
        break;
      }
    }
    bw.write(sum+"");
    bw.flush();
  }

  private static void union(int first, int second) {
    first = find(first);
    second = find(second);

    if(first > second) {
      parent[first] = second;
    } else {
      parent[second] = first;
    }
  }

  private static int find(int first) {
    if(parent[first] == first) {
      return first;
    } 
    return parent[first] = find(parent[first]);
  }
}
