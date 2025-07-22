import java.util.Scanner;

public class digitSum {

    public static int digitSum(int n) {
        if (n < 10) return n;
        return n % 10 + digitSum(n / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入一個正整數：");
        int n = sc.nextInt();
        System.out.println("各位數總和為：" + digitSum(n));
        sc.close();
    }
}
