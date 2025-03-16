package swea.d4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

class SWEA_5643_키_순서 {
    static int N;
    static int M;
    static List<Integer>[] graph1;
    static List<Integer>[] graph2;
    static boolean[] visit1;
    static boolean[] visit2;
    static Deque<Integer> deque;
    static int cnt1;
    static int cnt2;

    private static int bfs1(int num) { // 에서 나감 bfs

        deque = new ArrayDeque<>();

        deque.offerLast(num);
        visit1[num] = true;

        cnt1 = 0;
        while (!deque.isEmpty()) {

            int point = deque.pollFirst();
            //System.out.println("bfs1 point : " + point);

            for (int v : graph1[point]) {
                //System.out.println("연결된  v : " + v);
                if(visit1[v]==false) {
                    //System.out.println("추가되는 v : " + v);
                    deque.offerLast(v);
                    visit1[v] = true;
                    cnt1++;
                    //System.out.println("내부 cnt1  "+ cnt1);
                }
            }
        }
        return cnt1;
    } // cnt1

    private static int bfs2(int num) { // 으로 향함 bfs
        
        
        deque = new ArrayDeque<>();
        
        deque.offerLast(num);
        visit2[num] = true;
        
        cnt2 = 0;
        while(!deque.isEmpty()) {
            int point = deque.pollFirst();
            //System.out.println("bfs2 point : " + point);
            for (int v : graph2[point]) {
                //System.out.println("연결된  v : " + v);
                if(visit2[v]==false) {
                    //System.out.println("추가되는 v : " + v);
                    deque.offerLast(v);
                    visit2[v] = true;
                    cnt2++;
                    //System.out.println("내부 cnt2  "+ cnt2);
                }
            }
        }
        return cnt2;

    } // cnt2

    // cnt1 + cnt2 = N-1(본인 제외)면 알 수 있음

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine()); // 노드
            int M = Integer.parseInt(br.readLine()); // 간선

            graph1 = new ArrayList[N + 1];
            graph2 = new ArrayList[N + 1];
            
            for (int i = 0; i < N + 1; i++) {
                graph1[i] = new ArrayList<>();
                graph2[i] = new ArrayList<>();
            } // 초기화 해줌

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph1[u].add(v); // 단방향만 추가 //에서 나감 그래프
                graph2[v].add(u); // 단방향만 추가 //으로 향함 그래프
            } // 그래프 완성
            
            //System.out.println(Arrays.toString(graph1));
            //System.out.println(Arrays.toString(graph2));

            int count = 0;
            for (int i = 1; i <N+1; i++) {
                visit1 = new boolean[N + 1];
                visit2 = new boolean[N + 1];
                
                //System.out.println("--------------------------");
                //;System.out.println("현재 보고 있는 노드는? : " + i);
                int c1 = bfs1(i);
                int c2 = bfs2(i);
                //System.out.println("cnt1 값 : " + c1 );
                //System.out.println("cnt2 값 : " + c2);
                if (c1 + c2 == (N - 1)) {
                    count++;
                }
                //System.out.println("노드 " + i + "번의 count는? : " +count);
            }
            System.out.println("#" + tc + " " + count);
        }
    }//

}