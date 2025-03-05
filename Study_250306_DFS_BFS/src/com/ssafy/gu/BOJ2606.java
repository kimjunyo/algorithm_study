package com.ssafy.gu;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BOJ2606 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int com = sc.nextInt();
        int ssang = sc.nextInt();
        int[][] graph = new int[ssang][2];
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < ssang; i++) {
            int[] conn = new int[2];
            conn[0] = sc.nextInt();
            conn[1] = sc.nextInt();
            graph[i] = conn;
        }
        
        q.add(1);
        
        while (!q.isEmpty()) {
        	for (int i = 0; i < ssang; i++) {
        		int first = q.peek();
        		if (graph[i][0] == first) {
        			q.add(graph[i][1]);
        		}
        	}
        	set.add(q.poll());
        }
        
        System.out.println(set.size()-1);
    }
}