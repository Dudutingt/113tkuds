import java.util.*;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] games = new int[n];
        for (int i = 0; i < n; i++) {
            games[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        int[] prefix = new int[k];
        prefix[0] = games[0];
        for (int i = 1; i < k; i++) {
            prefix[i] = prefix[i - 1] + games[i];
        }

        System.out.print("PrefixSum:");
        for (int i = 0; i < k; i++) {
            System.out.print(" " + prefix[i]);
        }
        System.out.println();
    }
}
/*
 * Time Complexity: O(k)
 * 說明：建表時依序加總前綴，最多加 k 次，屬於線性時間。
 */
