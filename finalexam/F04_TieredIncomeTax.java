import java.util.Scanner;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] incomes = new int[n];
        for (int i = 0; i < n; i++) {
            incomes[i] = sc.nextInt();
        }

        int totalTax = 0;

        for (int i = 0; i < n; i++) {
            int income = incomes[i];
            int tax = calculateTax(income);
            totalTax += tax;
            System.out.println("Tax: $" + tax);
        }

        int avgTax = totalTax / n;
        System.out.println("Average: $" + avgTax);

        sc.close();
    }

  
    public static int calculateTax(int income) {
        if (income <= 540000) {
            return (int)(income * 0.05);
        } else if (income <= 1210000) {
            return (int)(income * 0.12 - 37800);
        } else if (income <= 2420000) {
            return (int)(income * 0.20 - 134600);
        } else if (income <= 4530000) {
            return (int)(income * 0.30 - 376600);
        } else {
            return (int)(income * 0.40 - 829600);
        }
    }
}
// 時間複雜度：O(n)
// 對每一筆收入呼叫常數時間的稅額計算，總共 n 筆。

// 空間複雜度：O(n)
// 使用一個長度為 n 的陣列儲存所有輸入收入。
