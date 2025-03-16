package programmers.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 점찍기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		int d = Integer.parseInt(br.readLine());
		
		long cnt = 0;
        for (int x = 0; x <= d; x += k) { 
            int maxY = (int) Math.sqrt((long) d * d - (long) x * x); 
            cnt += (maxY / k) + 1;  
        }
		System.out.println(cnt);
	}
}
