package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859_백만_장자_프로젝트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int len = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] price = new int[len];

            for (int i = 0; i < len; i++) 
                price[i] = Integer.parseInt(st.nextToken());

            long maxPrice = 0; 
            long profit = 0;    

            for (int i = len - 1; i >= 0; i--) {
                if (price[i] > maxPrice)  maxPrice = price[i]; 
                profit += (maxPrice - price[i]);
            }
            System.out.println("#" + tc + " " + profit);
        }
    }
}