package baekjoon.r3_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/* 시간초과남
public class BOJ_2493_탑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] building = new int[N];
		int[] recept = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			building[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=N-1; i>0; i--) {
			if(building[i] < building[i-1]) {
				recept[i] = i;
			}else {
				int j= i-1;
				while(j>=0 && building[i]>building[j]) {
					j--;
				}
				if(j <0) recept[i] = 0;
				else recept[i] = j+1;
			}
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(recept[i]+" ");
		}
	}
}
*/

/* 이것도 시간 초과^^ 인덱스 부분때문에
public class BOJ_2493_탑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> inputList = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			inputList.add(Integer.parseInt(st.nextToken()));
		}

		Stack<Integer> building = new Stack<>();	
		for (int num : inputList) {
			if(building.isEmpty()) {
				building.push(num);
				System.out.print(0+" ");
			} else if(building.peek()>num) {
				System.out.print((inputList.indexOf(building.peek())+1)+" ");
				building.push(num);
			} else if(building.peek()<num) {
				building.pop();
				if(building.isEmpty()) {
					System.out.print(0+" ");
				}else {
					System.out.print((inputList.indexOf(building.peek())+1)+" ");
				}
				building.push(num);
			}
		}
	}
}
*/

//Stack<int[]>
public class BOJ_2493_탑 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<int[]> building = new Stack<>(); // (탑의 높이, 인덱스) 저장

        for (int i = 1; i <= N; i++) { 
            int num = Integer.parseInt(st.nextToken());

            if (building.isEmpty()) {
                building.push(new int[]{num, i});
                System.out.print("0 ");
            } else if (building.peek()[0] > num) { 
                System.out.print(building.peek()[1] + " ");
                building.push(new int[]{num, i});
            } else { 
                while (!building.isEmpty() && building.peek()[0] < num) {
                    building.pop();
                }

                if (building.isEmpty()) {
                    System.out.print("0 ");
                } else {
                    System.out.print(building.peek()[1] + " ");
                }
                building.push(new int[]{num, i});
            }
        }
    }
}
