package com.ssafy.minji;

import java.util.*;
import java.io.*;

public class BOJ_1197_최소스패닝트리{
  static class Edge{
    int from;
    int to;
    int cost;
    public Edge(int from, int to, int cost){
      this.from = from;
      this.to = to;
      this.cost = cost;
    }
  }

  static int[] nodes;
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    nodes = new int[V + 1];
    for(int i = 1 ; i <= V ; i++){
      nodes[i] = i;
    }

    List<Edge> edgeList = new ArrayList<>();
    int A, B, C;
    for(int i = 0 ; i < E ; i++){
      st = new StringTokenizer(br.readLine());
      A = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
      Edge edge = new Edge(A, B, C);
      edgeList.add(edge);
    }

    Collections.sort(edgeList, new Comparator<Edge>(){
      @Override
      public int compare(Edge o1, Edge o2){
        return o1.cost - o2.cost;
      }
    });

    int cnt = 0;
    int costSum = 0;
    for(Edge edge : edgeList){
      if(union(edge.from, edge.to)){
          cnt++;
          costSum += edge.cost;
      }
      if(cnt == V-1){
        break;
      }
    }
    System.out.println(costSum);
    
  }

  static int find(int n){
    if(nodes[n] == n){
      return n;
    }
    return nodes[n] = find(nodes[n]);
  }

  static boolean union(int n1, int n2){
    int r1 = find(n1);
    int r2 = find(n2);
    if(r1 < r2){
      nodes[r2] = r1;
    }else if(r2 < r1){
      nodes[r1] = r2;
    }else{
      return false;
    }
    return true;
  }
}
