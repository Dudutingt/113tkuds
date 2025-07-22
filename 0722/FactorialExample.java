import java.util.Scanner;

public class FactorialExample {

    public static int factorial(int n) {
        if (n <= 1) {
            System.out.print("1");
            return 1;
        }
        System.out.print(n + " * ");
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  

        System.out.print("請輸入一個整數 n：");
        int n = sc.nextInt();  

        System.out.print(n + "! = ");
        int result = factorial(n);  
        System.out.println(" = " + result);  

        sc.close(); 
    }
}
