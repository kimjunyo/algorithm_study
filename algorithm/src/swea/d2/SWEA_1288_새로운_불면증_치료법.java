package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1288_새로운_불면증_치료법 {
    static int N;
    static boolean[] check;

    private static boolean isFull() {
        for (boolean b : check) {
            if (!b) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); 
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine()); 
            check = new boolean[10];
            int cnt = 0;

            while (true) {
                cnt++; 
                int num = N * cnt;
                char[] arr = String.valueOf(num).toCharArray();

                for (char a : arr) {
                    check[a - '0'] = true; 
                }

                if (isFull()) break;
            }

            System.out.println("#" + tc + " " + (N * cnt)); 
        }
    }
}
