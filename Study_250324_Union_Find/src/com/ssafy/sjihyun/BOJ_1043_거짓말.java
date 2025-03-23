package com.ssafy.sjihyun;

import java.util.*;
import java.io.*;

public class BOJ_1043_거짓말 {
    static int[] person;

    private static int findNode(int num) {
        if (person[num] == num) return num;
        return person[num] = findNode(person[num]);
    }

    private static void union(int num1, int num2) {
        int root1 = findNode(num1);
        int root2 = findNode(num2);
        
        if(root1 < root2) person[root2] = root1;
        else person[root1] = root2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  
        int M = Integer.parseInt(st.nextToken());  

        person = new int[N + 1];
        Arrays.setAll(person, i -> i); 

        st = new StringTokenizer(br.readLine());
        int knowTruthNum = Integer.parseInt(st.nextToken());
        
        if(knowTruthNum ==0) {
        	System.out.println(M);
        	return;
        }
		
		int mark = Integer.parseInt(st.nextToken());
		while (st.hasMoreTokens()) {
		    union(mark, Integer.parseInt(st.nextToken()));  
		}

        int[][] partyInfo = new int[M][];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            partyInfo[i] = new int[len];
            for (int j = 0; j < len; j++) {
                partyInfo[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < partyInfo[i].length-1; j++) {
            	union(partyInfo[i][j], partyInfo[i][j+1]);
            }
        }
        int cnt = M;
        int rootMark = findNode(mark);  
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < partyInfo[i].length; j++) {
            	if (findNode(partyInfo[i][j]) == rootMark) {   
                    cnt--;
                    break;
                }
            }
        }
        System.out.println(cnt);  
    }
}
