package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader
//import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1940_주몽 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  
        int M = Integer.parseInt(br.readLine());  

        int[] arr = new int[N]; 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); 
       // System.out.println(Arrays.toString(arr)); 

        int front = 0; 
        int rear = N - 1; 
        int count = 0; 

        while (front < rear) {
            int sum = arr[front] + arr[rear];  
            //System.out.println(front + ":" + rear + " 현재 합: " + sum);

            if (sum == M) {  
                count++;
                front++;
                rear--;
            } else if (sum > M) {  
                rear--;
            } else {  //s<M
                front++;
            }
        }
        System.out.println(count);
	}
}
