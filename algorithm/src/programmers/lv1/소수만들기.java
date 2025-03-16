package programmers.lv1;

public class 소수만들기 {
	
	static int[] nums = new int[] {1,2,7,6,4};
	static int[] arr = new int[3];
	static final int MAX = 2998;
	static boolean[] isNotPrime = new boolean[MAX]; //true : 소수 아님 //false : 소수임
	static int cnt = 0;
	
	private static void setPrime() {
		isNotPrime[0] = isNotPrime[1] = true;
		for(int i=2; i*i<MAX; i++) {
			if(!isNotPrime[i]) {
				for(int j=i*i; j<MAX; j+=i) {
					isNotPrime[j] = true;
				}
			}
		}
	}
	
	private static void combination(int depth, int last) {
		if(depth == 3) {
			int sum = 0;
			for(int n : arr) {
				sum += n;
			}
			if(!isNotPrime[sum]) cnt++;
			return;
		}
		
		for(int i=last+1; i<nums.length; i++){
			arr[depth] = nums[i];
			combination(depth+1,i);
		}
	}
	public static void main(String[] args) {
		setPrime();
		combination(0,-1);
		
		System.out.println(cnt);
	}

}
