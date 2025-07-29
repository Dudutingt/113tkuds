import java.util.Scanner;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] stations = new String[n];
        for (int i = 0; i < n; i++) {
            stations[i] = sc.next();
        }

        String start = sc.next();
        String end = sc.next();

        int indexStart = -1;
        int indexEnd = -1;

        for (int i = 0; i < n; i++) {
            if (stations[i].equals(start)) {
                indexStart = i;
            }
            if (stations[i].equals(end)) {
                indexEnd = i;
            }
        }

        if (indexStart == -1 || indexEnd == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(indexStart - indexEnd) + 1);
        }

        sc.close();
    }
}
// 時間複雜度：O(n)
// 只需一次迴圈掃描站名陣列找出起訖站索引，時間為 O(n)。
//
// 空間複雜度：O(n)
// 儲存 n 個站名所需空間，額外變數皆為常數等級。
