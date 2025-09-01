import java.util.Scanner;

public class cir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        double area = 3.14 * r * r;
        System.out.printf("%.2f\n", area);
    }
}
