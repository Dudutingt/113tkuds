import java.util.*;

public class Q3_NightMarketRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] scores = new double[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
        }

        for (int i = 0; i < Math.min(5, n); i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIdx]) {
                    maxIdx = j;
                }
            }
            double temp = scores[i];
            scores[i] = scores[maxIdx];
            scores[maxIdx] = temp;
            System.out.printf("%.1f\n", scores[i]);
        }
    }
}
/*
 * Time Complexity: O(n^2)
 * 說明：使用選擇排序，最多排序前 5 名，每輪找最大值需 O(n-i) 次比較。
 */
