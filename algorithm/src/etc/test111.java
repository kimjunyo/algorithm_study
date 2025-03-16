package etc;

public class test111 {
    static int N = 7;  
    static int k = 3;  
    static int[] num = new int[k];  

    public static void main(String[] args) {
        findValidCombinations(0, 0);
    }

    private static void findValidCombinations(int depth, int sum) {
        if (depth == 2) {  
            if (sum < N) {
                int remaining = N - sum;  
                if (remaining >= 1) {  
                    num[2] = remaining;
                    printCombination();
                }
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            num[depth] = i;
            findValidCombinations(depth + 1, sum + i);  
        }
    }

    private static void printCombination() {
        for (int i = 0; i < k; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }
}
