package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Stack<Integer> idxStack = new Stack<>();  
        int[] arr = new int[N];     
        int[] result = new int[N]; 
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            result[i] = -1;
        }
        for (int i = 0; i < N; i++) {
            while (!idxStack.isEmpty() && arr[idxStack.peek()] < arr[i]) {
                result[idxStack.pop()] = arr[i]; 
            }
            idxStack.push(i);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
        	sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}