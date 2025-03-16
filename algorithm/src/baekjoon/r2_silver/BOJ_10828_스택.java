package baekjoon.r2_silver;
import java.util.Scanner;

public class BOJ_10828_스택 { 
    private int[] stack;
    private int top;

    public BOJ_10828_스택(int size) {
        stack = new int[size];
        top = -1;
    }

    public int pop() {
        if (top == -1) return -1;
        return stack[top--];
    }

    public int size() {
        return top + 1;
    }

    public int empty() {
        return (top == -1) ? 1 : 0;
    }

    public int top() {
        if (top == -1) return -1;
        return stack[top];
    }

    public void push(int num) {
        stack[++top] = num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거

        BOJ_10828_스택 stack = new BOJ_10828_스택(N); // 객체 생성

        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();

            if (command.equals("pop")) {
                System.out.println(stack.pop());
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                System.out.println(stack.empty());
            } else if (command.equals("top")) {
                System.out.println(stack.top());
            } else { // push
                String[] parts = command.split(" ");
                int num = Integer.parseInt(parts[1]);
                stack.push(num);
            }
        }

        sc.close();
    }
}
