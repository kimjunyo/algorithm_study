package tip;

public class 순열 {
	
	static int[] arr = {1,2};
	static int[] num = new int[4];
	
	public static void main(String[] args) {
		perm(0);
	}
	
	private static void perm(int depth) {
		
		if(depth ==4) {
			for(int n : num) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<2; i++) {
			num[depth] = arr[i];
			perm(depth+1);
		}
	}
}
