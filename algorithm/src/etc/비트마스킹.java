package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비트마스킹 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); 
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine()); 
            int seen = 0; // ✅ 비트마스킹으로 숫자 방문 여부 체크
            int cnt = 0;

            while (seen != 0b1111111111) { // ✅ 모든 숫자가 등장했는지 비트마스크 체크 (0~9 모두 포함)
                cnt++; 
                int num = N * cnt;

                // ✅ 숫자 하나씩 분리해서 비트마스킹 처리
                while (num > 0) {
                    seen |= (1 << (num % 10)); // 현재 숫자의 해당 자리수를 방문 처리
                    num /= 10;
                }
            }

            System.out.println("#" + tc + " " + (N * cnt)); 
        }
    }
}
