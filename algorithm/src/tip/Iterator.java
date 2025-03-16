package tip;

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1230_암호문3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<String> linklist = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				linklist.add(st.nextToken());
				
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int t = 1; t<=M; t++) {
				String check = st.nextToken();
				if(check.equals("I")) {
					int spot = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					for(int i=1; i<=num; i++) {
						linklist.add(spot++, st.nextToken());
					}
				}else if(check.equals("D")) {
					int spot = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					for(int i=1; i<=num; i++) {
						linklist.remove(spot);
					}
				}else if(check.equals("A")) {
					int num = Integer.parseInt(st.nextToken());
					for(int i=1; i<=num; i++) {
						linklist.addLast(st.nextToken());
					}
				}
			}
			
			sb.append("#"+tc+" ");
			for(int i=0; i<10; i++) {
				sb.append(linklist.get(i)).append(" ");
			}
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Iterator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            LinkedList<String> list = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                list.add(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                String command = st.nextToken();

                if (command.equals("I")) { // 삽입
                    int index = Integer.parseInt(st.nextToken());
                    int num = Integer.parseInt(st.nextToken());

                    ListIterator<String> iter = list.listIterator(index);
                    for (int i = 0; i < num; i++) {
                        iter.add(st.nextToken()); // Iterator를 이용한 삽입
                    }
                } 
                else if (command.equals("D")) { // 삭제
                    int index = Integer.parseInt(st.nextToken());
                    int num = Integer.parseInt(st.nextToken());

                    ListIterator<String> iter = list.listIterator(index);
                    for (int i = 0; i < num; i++) {
                        iter.next();  // 한 칸 이동
                        iter.remove(); // 현재 위치 삭제
                    }
                } 
                else if (command.equals("A")) { // 추가
                    int num = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < num; i++) {
                        list.addLast(st.nextToken()); // 맨 끝에 추가
                    }
                }
            }
            
            sb.append("#"+tc+" ");
			for(int i=0; i<10; i++) {
				sb.append(list.pollFirst()).append(" ");
			}
			System.out.println(sb);
			sb.setLength(0);
        }
        System.out.print(sb.toString());
    }
}
