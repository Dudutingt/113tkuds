import java.util.Scanner;

public class auto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        double b = sc.nextDouble();
        double sum = a + b; 
        System.out.printf("%.2f\n", sum);
    }
}
