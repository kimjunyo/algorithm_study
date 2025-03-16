package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7272_안경이_없어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 알파벳별 구멍 개수 저장 (A~Z → 인덱스 0~25)
        int[] holeCount = new int[26];
        for (char c : "CEFGHIJKLMNSTUVWXYZ".toCharArray()) holeCount[c - 'A'] = 0;
        for (char c : "ADOPQR".toCharArray()) holeCount[c - 'A'] = 1;
        holeCount['B' - 'A'] = 2;

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String check1 = st.nextToken();
            String check2 = st.nextToken();

            if (check1.length() != check2.length()) {
                sb.append("#").append(tc).append(" DIFF\n");
                continue;
            }

            boolean isSame = true;
            for (int i = 0; i < check1.length(); i++) {
                if (holeCount[check1.charAt(i) - 'A'] != holeCount[check2.charAt(i) - 'A']) {
                    sb.append("#").append(tc).append(" DIFF\n");
                    isSame = false;
                    break;
                }
            }
            if (isSame) sb.append("#").append(tc).append(" SAME\n");
        }
        System.out.print(sb);
    }
}
