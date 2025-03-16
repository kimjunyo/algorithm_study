package tip;

public class 에라토스테네스의체 {
	static final int MAX = 10000000;
	static boolean[] isNotPrime = new boolean[MAX+1];

	private static void checkPrime() {

		isNotPrime[0] = isNotPrime[1] = true;

		for (int i = 2; i * i <= MAX; i++) {
			if (!isNotPrime[i]) { //소수라면
				for (int j = i * i; j <= MAX; j += i) {
					isNotPrime[j] = true;
				}

			}
		}

	}

	public static void main(String[] args) {
		
		//만들고 호출을 해야지!!!!!!!!!
		checkPrime();
		System.out.println(isNotPrime[9]);
		//false가 나오면 소수임
		//true가 나오면 소수가 아님 

	}

}
