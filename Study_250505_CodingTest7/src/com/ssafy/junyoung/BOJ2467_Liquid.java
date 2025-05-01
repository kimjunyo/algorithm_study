import java.util.*;
import java.io.*;

public class Main{
  static int N;

  static class Number implements Comparable<Number> {
    int value, original;

    Number(int value, int original) {
      this.value = value;
      this.original = original;
    }

    @Override
    public int compareTo(Number num) {
      return this.value - num.value;
    }
  }
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    PriorityQueue<Number> pq = new PriorityQueue<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      int input = Integer.parseInt(st.nextToken());
      if(input < 0) {
        pq.offer(new Number(-input, input));
      } else {
        pq.offer(new Number(input, input));
      }
    }
    
    Number firstNum = pq.poll();
    Number secondNum;
    int first = 0;
    int second = 0;
    int min = 2_000_000_000;
    
    while(!pq.isEmpty()) {
      secondNum = pq.poll();
      if(Math.abs(firstNum.original + secondNum.original) < min) {
        first = firstNum.original;
        second = secondNum.original;
        min = Math.abs(firstNum.original + secondNum.original);
      }
      
      firstNum = secondNum;
    }
    StringBuilder sb = new StringBuilder();
    if(first < second) {
      sb.append(first).append(" ").append(second);
    } else {
      sb.append(second).append(" ").append(first);
    }
    bw.write(sb.toString());
    bw.flush();
  }
}
