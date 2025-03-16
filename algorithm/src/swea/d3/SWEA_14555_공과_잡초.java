package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_14555_공과_잡초 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String s = br.readLine(); 
            int cnt = 0;
            int cnt2 = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') cnt++; 
                if(s.charAt(i) == '(' || s.charAt(i) == ')') cnt2++;
            }
            if(s.charAt(s.length()-1)==')') cnt2++;
            System.out.println("#" + tc + " " + (cnt2-cnt));
        }
    }
}
