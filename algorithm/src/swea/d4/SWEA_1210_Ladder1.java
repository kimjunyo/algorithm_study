package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1210_Ladder1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) { ///////////// 나중에 수정해라!!!!!!!!!!!!!!!
			int T = Integer.parseInt(br.readLine());

			int[][] arr = new int[100][100];////수정

			int r = 0, c = 0;
			for (int i = 0; i < 100; i++) { ////수정
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 0) {
						arr[i][j] = -1;
					}
					
					if (arr[0][j] == 1) {
						arr[0][j] = j;
					}
					if (arr[i][j] == 2) {
						r = i; c = j;
						arr[i][j] =1;
					}
					
				}
			}

//			for(int i=0; i<arr.length; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}

			// 시작점을 정했음
//			System.out.println(r);
//			System.out.println(c);
//			System.out.println(arr[r][c]); //당연히 1
			int idx = 0;
			while (r != 0) {
				if (0 < c && c < 99) { //나 왼쪽 오른쪽 위  ///////////수정
					if (arr[r][c] == 1 && arr[r][c-1] == -1 && arr[r][c+1] == -1 && arr[r - 1][c] != -1) { // 위로
						arr[r][c] = -1;
						r--;
					} else if (arr[r][c] == 1 && arr[r][c-1] == 1 && arr[r][c+1] == -1) { // 왼쪽으로 가야함
						arr[r][c] = -1;
						c--;
					} else { // 오른쪽
						arr[r][c] = -1;
						c++;
					} 
				} else if (c == 0) { // 왼쪽끝
					if (arr[r][c] == 1 && arr[r][c+1] == -1 && arr[r - 1][c] != -1) { //위로
						arr[r][c] = -1;
						r--;
					} else if (arr[r][c] == 1 &&  arr[r][c+1] == 1) { // 오른쪽으로 가야함
						arr[r][c] = -1;
						c++;
					}
				} else { // 오른쪽끝 c==99
					if (arr[r][c] == 1 && arr[r][c-1] == -1 && arr[r - 1][c] != -1) { //위로
						arr[r][c] = -1;
						r--;
					} else if (arr[r][c] == 1 && arr[r][c-1] == 1) { // 왼쪽
						arr[r][c] = -1;
						c--;
					}
				}
				
				if(r==0) { 
					idx = c;
					break;
				}
			}
			System.out.println("#"+tc+" "+idx);
		}
	}
}
