import java.util.Scanner;

public class gcd {

    
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入兩個正整數：");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int result = gcd(a, b);
        System.out.println("最大公因數 GCD(" + a + ", " + b + ") = " + result);

        sc.close();
    }
}
