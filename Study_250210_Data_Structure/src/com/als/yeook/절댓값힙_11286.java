package com.als.yeook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 절댓값힙_11286 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 우선순위 큐만들고 절댓값을 기준으로 저장하기.
		PriorityQueue<Integer> heap = new PriorityQueue<>(new CompareAbs());
		StringBuilder result = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			if (num != 0) {
				heap.offer(num);
			} else {
				Integer pop = heap.poll();
				if (pop != null)
					result.append(pop).append("\n");
				else
					result.append("0\n");

			}
		}
		bw.write(result.toString().trim());
		bw.flush();
	}

}

//우선순위 큐의 인자로 넣을 Comparator구현한 클래스 만들기.
//compare메서드 호출 결과를 기준으로 큐에 저장됨.
class CompareAbs implements Comparator<Integer> {

	@Override
	public int compare(Integer a, Integer b) {
		if (Math.abs(a) > Math.abs(b)) {
			return 1; // 양수이면 자리 바꿈.
		} else if (Math.abs(a) == Math.abs(b)) {
			return a - b;// 같으면 음수가 앞이있도록 함.
		} else {
			return -1; // 음수이면 자리 그대로.
		}
	}
}