import java.util.Scanner;

public class array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N][M];
        int[] colSum = new int[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                colSum[j] += arr[i][j];
            }
        }

        for (int j = 0; j < M; j++) {
            System.out.print(colSum[j]);
            if (j < M - 1) {
                System.out.print(" ");
            }
        }
    }
}
