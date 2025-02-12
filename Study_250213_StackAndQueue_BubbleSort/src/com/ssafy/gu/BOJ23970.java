import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ23970 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		
		String a = br.readLine();
		StringTokenizer st = new StringTokenizer(a);
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken()); 
		}
		
		String b = br.readLine();
		st = new StringTokenizer(b);
		int diff = 0;
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
			if (A[i] == B[i]) continue;
			diff++;
		}
		if (diff == 0) { System.out.println(1); return; }
				
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-i-1; j++) {
				if (A[j] > A[j+1]) {
					int before1 = A[j] != B[j] ? 1 : 0;
					int before2 = A[j+1] != B[j+1] ? 1 : 0;
					
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
					
					int after1 = A[j] != B[j] ? 1 : 0;
					int after2 = A[j+1] != B[j+1] ? 1 : 0;
					
					diff -= (before1 + before2 - after1 - after2);
					
					if (diff == 0) { System.out.println(1); return; }
				}
			}
		}
		
		System.out.println(0);
	}
}
