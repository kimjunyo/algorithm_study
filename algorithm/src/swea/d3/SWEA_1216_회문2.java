package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SWEA_1216_회문2 {
	static final int SIZE = 100;
	static final int CASE = 10;

	static int findMax(String[] arrList) throws IOException {
	    int max = 0; 
	    List<Integer> idxListOdd;
	    List<Integer> idxListEven;
	    
//	    System.out.println("------------------------------------");
//		for(int i=0; i<arrList.length; i++) {
//			System.out.println(arrList[i]);
//		}

	    for (int i = 0; i < SIZE; i++) {
	        int max1 = 0; 
	        int max2 = 0;

	        idxListOdd = idxCheck(arrList[i], 0);
	        for (Integer c : idxListOdd) {
	            int d = 1;
	            while (0 <= c - d && c + d < SIZE) {
	                if (arrList[i].charAt(c - d) == arrList[i].charAt(c + d)) d++;
	                else break;
	                max1 = Math.max(max1, 2 * (d - 1) + 1);
	            }
	        }

	        idxListEven = idxCheck(arrList[i], 1);
	        for (Integer c : idxListEven) {
	            int d = 1;
	            while (0 <= c - d && (c + 1) + d < SIZE) {
	                if (arrList[i].charAt(c - d) == arrList[i].charAt((c + 1) + d)) d++;
	                else break;
	                max2 = Math.max(max2, 2 + (d - 1) * 2);
	            }
	        }
	        max = Math.max(max, Math.max(max1, max2)); 
	    }
	    return max;
	}

	static List<Integer> idxCheck(String input, int num) throws IOException {
		List<Integer> idxList = new ArrayList<>();

		String[] checkArr = { "AAA", "ABA", "ACA", 
							  "BAB", "BBB", "BCB", 
							  "CAC", "CBC", "CCC", 
							  "AA", "BB", "CC" };

		if (num == 0) { //홀수
			for (int i = 0; i < checkArr.length - 3; i++) {
				int idx = input.indexOf(checkArr[i]);
				while (idx != -1) {
					idxList.add(idx + 1);
					idx = input.indexOf(checkArr[i], idx + 1); 
				}
			}
		} else { //짝수
			for (int i = checkArr.length - 3; i < checkArr.length; i++) {
				int idx = input.indexOf(checkArr[i]);
				while (idx != -1) {
					idxList.add(idx);
					idx = input.indexOf(checkArr[i], idx + 1);
				}
			}
		}
		return idxList;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= CASE; tc++) {
			int T = Integer.parseInt(br.readLine());

			char[][] arr = new char[SIZE][SIZE];
			String[] arrList = new String[SIZE];
			//가로
			for (int i = 0; i < SIZE; i++) {
				arr[i] = br.readLine().toCharArray();
				arrList[i] = String.valueOf(arr[i]);
			}
//			System.out.println("88888888888888888888888");
//			System.out.println(Arrays.toString(arrList));
			int hMax = findMax(arrList);

			//세로
			arrList = new String[SIZE];
			for (int j = 0; j < SIZE; j++) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < SIZE; i++) sb.append(arr[i][j]);
				arrList[j] = sb.toString();
			}
//			System.out.println("88888888888888888888888");
//			System.out.println(Arrays.toString(arrList));
			
			int vMax = findMax(arrList);
//			System.out.println(hMax);
//			System.out.println(vMax);
			
			System.out.println("# "+tc+" "+ Math.max(hMax, vMax));
		}
	}
}


//////////////


