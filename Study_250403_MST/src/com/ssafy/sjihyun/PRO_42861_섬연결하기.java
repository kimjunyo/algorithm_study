import java.util.*;
import java.io.*;

class Solution {
    
    static int[] node;
    
    private class Edge{
        int from, to, cost;
        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost; 
        }
    }
    
    private static int findNode(int num){
        if(node[num] == num) return num;
        return node[num] = findNode(node[num]);
    }
    
    private static boolean unionFind(int numA, int numB){
        int rootA = findNode(numA);
        int rootB = findNode(numB);
        
        if(rootA == rootB) return false;
        
        if(rootA < rootB) node[rootB] = rootA;
        else node[rootA] = rootB;
        return true;
    }
    
    public int solution(int n, int[][] costs) {
        node = new int[n];
        Arrays.setAll(node, i->i);
        List<Edge> edges = new ArrayList<>();
        
        for(int i=0; i<costs.length; i++){
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];
            edges.add(new Edge(from, to, cost));
        }
        
        // System.out.println(edges);
        edges.sort((e1,e2) -> Integer.compare(e1.cost, e2.cost));
        
        int totalCost = 0, cnt = 0;
        for(Edge edge : edges){
            if(unionFind(edge.from, edge.to)){
                cnt++;
                totalCost+= edge.cost;
                if(cnt == n-1) break;
            }
        }
        return totalCost;
    }
}