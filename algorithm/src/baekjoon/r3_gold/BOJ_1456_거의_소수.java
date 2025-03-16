package baekjoon.r3_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1456_거의_소수 {
    
    static boolean[] isNotPrime;
    static long sqrtB;

    // 소수 체크 함수
    private static void checkPrime() {
        isNotPrime[0] = isNotPrime[1] = true;
        for(long i = 2; i * i <= sqrtB; i++) {
            if(!isNotPrime[(int)i]) {
                for(long j = i * i; j <= sqrtB; j += i) {
                    isNotPrime[(int)j] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
    
        sqrtB = (long) Math.sqrt(B);  // B의 제곱근
    
        // 배열 크기 조정, B+1을 int로 설정
        isNotPrime = new boolean[(int)(sqrtB + 1)];
        checkPrime();
        
        int cnt = 0;
        for(long i = 2; i <= sqrtB; i++) {
            if(!isNotPrime[(int)i]) {
                long cal = i * i;  // i^2부터 시작
                while(cal <= B) {
                    if(A <= cal && cal <= B) {
                        cnt++;
                    }
                    // 오버플로우 방지
                    if(cal > B / i) break;
                    cal *= i;
                }
            }
        }
        System.out.println(cnt);  // 결과 출력
    }
}
