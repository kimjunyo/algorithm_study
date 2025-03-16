package tip;
/*
📌 문제 복원 (완성본)
💡 문제 설명
비료는 2종류(1번, 2번)
N개의 화분이 있으며, 각 화분은 2개의 선택지(높이)가 주어짐
매 단계에서 두 개의 선택지 중 하나를 선택해야 한다.
단, 같은 비료를 연속해서 사용하면 P만큼 성장량이 감소한다.
성장량 감소는 누적되지 않는다.
비료를 총 N번 사용했을 때, 식물의 총 성장량이 최대가 되는 경우를 구하라.

📌 입력
첫 번째 줄: 정수 N (1 ≤ N ≤ 20) (화분 개수) 정수 P (1 ≤ P ≤ 10) (같은 비료 연속 사용 시 감소량)
두 번째 줄: N개의 정수 H1A, H2A, ..., HNA (각 화분에서 1번 비료 사용 시 성장 높이)
세 번째 줄: N개의 정수 H1B, H2B, ..., HNB (각 화분에서 2번 비료 사용 시 성장 높이)

📌 출력
최대로 성장할 수 있는 총 높이

////////////////////////
4 2
4 6 2 5
1 9 5 2

21
 */



/////////// 완전 탐색 (백트래킹)
/*
import java.util.*;
public class A형1번문제복원 {
    static int N, P;
    static int[][] growth, penaltyGrowth;
    static int maxGrowth = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        growth = new int[2][N];  // growth[0][i]: 1번 비료, growth[1][i]: 2번 비료
        penaltyGrowth = new int[2][N];  // 페널티 적용된 성장량

        for (int i = 0; i < N; i++) growth[0][i] = sc.nextInt();
        for (int i = 0; i < N; i++) growth[1][i] = sc.nextInt();
        P = sc.nextInt();

        // 패널티 적용 배열 생성
        for (int i = 0; i < N; i++) {
            penaltyGrowth[0][i] = Math.max(0, growth[0][i] - P);
            penaltyGrowth[1][i] = Math.max(0, growth[1][i] - P);
        }

        // 완전 탐색 (백트래킹)
        dfs(0, -1, 0);  // (현재 인덱스, 이전 비료, 현재 성장량)

        System.out.println(maxGrowth);
    }

    static void dfs(int idx, int prevFertilizer, int totalGrowth) {
        if (idx == N) {  // 모든 화분에 비료를 줬다면
            maxGrowth = Math.max(maxGrowth, totalGrowth);
            return;
        }

        // 1번 비료 선택
        if (prevFertilizer == 1) { // 연속 사용
            dfs(idx + 1, 1, totalGrowth + penaltyGrowth[0][idx]);
        } else { // 연속이 아님
            dfs(idx + 1, 1, totalGrowth + growth[0][idx]);
        }

        // 2번 비료 선택
        if (prevFertilizer == 2) { // 연속 사용
            dfs(idx + 1, 2, totalGrowth + penaltyGrowth[1][idx]);
        } else { // 연속이 아님
            dfs(idx + 1, 2, totalGrowth + growth[1][idx]);
        }
    }
}
*/


/////////////모든 조합을 만들어서 탐색
/*
import java.util.*;

public class A형1번문제복원 {
    static int N, P;
    static int[][] growth, penaltyGrowth;
    static List<int[]> combinations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        growth = new int[2][N];  // growth[0][i]: 1번 비료, growth[1][i]: 2번 비료
        penaltyGrowth = new int[2][N];  // 패널티 적용된 성장량

        for (int i = 0; i < N; i++) growth[0][i] = sc.nextInt();
        for (int i = 0; i < N; i++) growth[1][i] = sc.nextInt();
        P = sc.nextInt();

        // 패널티 적용 배열 생성
        for (int i = 0; i < N; i++) {
            penaltyGrowth[0][i] = Math.max(0, growth[0][i] - P);
            penaltyGrowth[1][i] = Math.max(0, growth[1][i] - P);
        }

        // 1️⃣ 모든 경우의 조합 미리 생성
        generateCombinations(N, new int[N], 0);

        // 2️⃣ 각 조합별 성장량 계산 & 최대값 갱신
        int maxGrowth = 0;
        for (int[] comb : combinations) {
            maxGrowth = Math.max(maxGrowth, calculateGrowth(comb));
        }

        System.out.println(maxGrowth);
    }

    // 모든 경우의 조합을 미리 저장하는 함수
    static void generateCombinations(int length, int[] current, int idx) {
        if (idx == length) {
            combinations.add(current.clone()); // 배열 복사 후 리스트에 저장
            return;
        }
        current[idx] = 1;
        generateCombinations(length, current, idx + 1);
        current[idx] = 2;
        generateCombinations(length, current, idx + 1);
    }

    // 특정 조합에 대해 성장량 계산
    static int calculateGrowth(int[] comb) {
        int totalGrowth = 0;
        int prevFertilizer = -1; // 직전 비료 종류 저장

        for (int i = 0; i < N; i++) {
            if (comb[i] == prevFertilizer) { // 연속 사용 시 패널티 적용
                totalGrowth += penaltyGrowth[comb[i] - 1][i];
            } else { // 다른 비료 사용 시 일반 성장량 적용
                totalGrowth += growth[comb[i] - 1][i];
            }
            prevFertilizer = comb[i];
        }

        return totalGrowth;
    }
}
*/


//DP
import java.util.*;

public class A형1번문제복원 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] growth = new int[2][N];  // growth[0][i]: 1번 비료 성장량, growth[1][i]: 2번 비료 성장량
        int[][] penaltyGrowth = new int[2][N];  // penaltyGrowth[0][i]: 연속 사용 시 1번 비료 성장량, penaltyGrowth[1][i]: 연속 사용 시 2번 비료 성장량
        int P = sc.nextInt();

        for (int i = 0; i < N; i++) growth[0][i] = sc.nextInt();
        for (int i = 0; i < N; i++) growth[1][i] = sc.nextInt();

        for (int i = 0; i < N; i++) {
            penaltyGrowth[0][i] = Math.max(0, growth[0][i] - P);
            penaltyGrowth[1][i] = Math.max(0, growth[1][i] - P);
        }

        // DP 테이블
        int[][] dp = new int[N][2];

        // 초기값 설정 (첫 번째 화분)
        dp[0][0] = growth[0][0];  // 첫 번째 화분에 1번 비료 사용
        dp[0][1] = growth[1][0];  // 첫 번째 화분에 2번 비료 사용

        // DP 상태 전이
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i-1][1] + growth[0][i], dp[i-1][0] + penaltyGrowth[0][i]);
            dp[i][1] = Math.max(dp[i-1][0] + growth[1][i], dp[i-1][1] + penaltyGrowth[1][i]);
        }

        // 최댓값 출력
        System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
    }
}