package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2527_직사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int tc = 0; tc < 4; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());
            int y3 = Integer.parseInt(st.nextToken());
            int x4 = Integer.parseInt(st.nextToken());
            int y4 = Integer.parseInt(st.nextToken());
            
            // 안만남
            if (x2 < x3 || x4 < x1 || y2 < y3 || y4 < y1) {
                System.out.println("d");
            }
            // 점
            else if ((x2 == x3 && y2 == y3) || (x2 == x3 && y1 == y4) ||
                     (x1 == x4 && y2 == y3) || (x1 == x4 && y1 == y4)) {
                System.out.println("c");
            }
            // 선
            else if (x2 == x3 || x1 == x4 || y2 == y3 || y1 == y4) {
                System.out.println("b");
            }
            // 면
            else {
                System.out.println("a");
            }
        }
    }
}
