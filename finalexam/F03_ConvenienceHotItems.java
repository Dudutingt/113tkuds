import java.util.Scanner;

public class F03_ConvenienceHotItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] names = new String[n];
        int[] qtys = new int[n];

        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            names[i] = line[0];
            qtys[i] = Integer.parseInt(line[1]);
        }

       
        for (int i = 1; i < n; i++) {
            String currentName = names[i];
            int currentQty = qtys[i];
            int j = i - 1;

            while (j >= 0 && qtys[j] < currentQty) {
                names[j + 1] = names[j];
                qtys[j + 1] = qtys[j];
                j--;
            }
            names[j + 1] = currentName;
            qtys[j + 1] = currentQty;
        }

        
        int outputCount = Math.min(n, 10);
        for (int i = 0; i < outputCount; i++) {
            System.out.println(names[i] + " " + qtys[i]);
        }

        sc.close();
    }
}
// 時間複雜度：O(n^2)
// 插入排序在最壞情況下（完全反序）需 O(n^2) 次比較與搬移。

// 空間複雜度：O(n)
// 使用兩個長度為 n 的陣列儲存名稱與銷量。
