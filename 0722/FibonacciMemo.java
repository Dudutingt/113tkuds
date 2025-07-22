import java.util.Scanner;

public class FibonacciMemo {

    public static int fibonacciFast(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciFast(n - 1, memo) + fibonacciFast(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入 n：");
        int n = sc.nextInt();
        int[] memo = new int[n + 1];
        System.out.println("第 " + n + " 項 Fibonacci（記憶化）為：" + fibonacciFast(n, memo));
        sc.close();
    }
}
