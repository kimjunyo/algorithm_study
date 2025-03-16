package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1974_스도쿠검증 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        outerLoop:
        for (int tc = 1; tc <= T; tc++) {
            int[][] field = new int[9][9];

            // 필드 입력
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    field[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 행 & 열 검사
            for (int i = 0; i < 9; i++) {
                boolean[] rowCheck = new boolean[10]; // 1~9까지 체크 (index 0은 사용X)
                boolean[] colCheck = new boolean[10];

                for (int j = 0; j < 9; j++) {
                    int rowNum = field[i][j];
                    int colNum = field[j][i];

                    // 행 중복 체크
                    if (rowCheck[rowNum]) {
                        System.out.println("#" + tc + " 0");
                        continue outerLoop;
                    }
                    rowCheck[rowNum] = true;

                    // 열 중복 체크
                    if (colCheck[colNum]) {
                        System.out.println("#" + tc + " 0");
                        continue outerLoop;
                    }
                    colCheck[colNum] = true;
                }
            }

            // 3×3 박스 검사
            for (int r = 0; r < 9; r += 3) {
                for (int c = 0; c < 9; c += 3) {
                    boolean[] boxCheck = new boolean[10];

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            int num = field[r + i][c + j];

                            if (boxCheck[num]) {
                                System.out.println("#" + tc + " 0");
                                continue outerLoop;
                            }
                            boxCheck[num] = true;
                        }
                    }
                }
            }

            // 모든 검사를 통과하면 1 출력
            System.out.println("#" + tc + " 1");
        }
    }
}
