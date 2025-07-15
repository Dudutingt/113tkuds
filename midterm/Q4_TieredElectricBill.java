import java.util.*;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] kWhs = new int[n];
        for (int i = 0; i < n; i++) {
            kWhs[i] = sc.nextInt();
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            int bill = calc(kWhs[i]);
            total += bill;
            System.out.println("Bill: $" + bill);
        }
        int avg = Math.round((float) total / n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + avg);
    }

    static int calc(int kWh) {
        int[] limits = {120, 210, 170, 200, 300, Integer.MAX_VALUE};
        double[] rates = {1.68, 2.45, 3.70, 5.04, 6.24, 8.46};
        int bill = 0, remain = kWh;
        for (int i = 0; i < limits.length && remain > 0; i++) {
            int use = Math.min(remain, limits[i]);
            bill += Math.round(use * rates[i]);
            remain -= use;
        }
        return bill;
    }
}
/*
 * Time Complexity: O(n)
 * 說明：每個電量呼叫 calc 計算，內含固定次數段落運算為 O(1)，共 n 筆為 O(n)。
 */
