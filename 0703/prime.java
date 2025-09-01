import java.util.Scanner;

public class prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 2; i <= N; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break; 
                }
            }
            if (isPrime) {
                System.out.print(i);
                if (i < N) {
                    
                    int next = i + 1;
                    while (next <= N) {
                        boolean nextPrime = true;
                        for (int k = 2; k * k <= next; k++) {
                            if (next % k == 0) {
                                nextPrime = false;
                                break;
                            }
                        }
                        if (nextPrime) {
                            System.out.print(" ");
                            break;
                        }
                        next++;
                    }
                }
            }
        }
    }
}