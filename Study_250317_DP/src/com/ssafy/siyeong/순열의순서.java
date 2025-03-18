import java.util.Arrays;
import java.util.Scanner;

//시간초과...................
//브루트포스로 모든걸찾으면 안된다는거까지 ok
//그럼 수학적인 계산이 필요한거야???
public class 순열의순서 {
	static int k;
	static int N;
	static int cnt;
	static boolean[] visited;
	static int[] result;
	static int[] nums;
	static int[] compare;
	static boolean end;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int num = sc.nextInt();
		visited = new boolean[N];
		result = new int[N];
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = i + 1;
		}
		if (num == 1) {
			k = sc.nextInt();
			for (int i = 0; i < N; i++) {
				nums[i] = i + 1;
			}
			perm1(0);
		}
		else {
			compare = new int[N];
			for (int i = 0; i < N; i++) {
				compare[i] = sc.nextInt();
			}
			perm2(0);
		}
			
	}

	private static void perm1(int idx) {
		if (idx == N) {
			cnt++;
			if (cnt == k) {
				for (int i = 0; i < N; i++) {
					System.out.print(result[i] + " ");
				}
				System.out.println();
				end = true;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if (end) return;
			if (visited[i]) continue;
			
			result[idx] = nums[i];
			visited[i] = true;
			perm1(idx + 1);
			visited[i] = false;
			
		}
		
	}
	private static void perm2(int idx) {
		if (idx == N) {
			cnt++;
			for (int i = 0; i < N; i++) {
				if (compare[i] != result[i]) return;
			}
			System.out.println(cnt);
			end = true;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (end) return; 
			if (visited[i]) continue;
			result[idx] = nums[i];
			visited[i] = true;
			perm2(idx + 1);
			visited[i] = false;
			
		}
		
	}
}
