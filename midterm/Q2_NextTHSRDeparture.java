import java.util.*;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] times = new int[n];
        sc.nextLine(); // consume newline
        for (int i = 0; i < n; i++) {
            String time = sc.nextLine();
            times[i] = toMinutes(time);
        }
        String query = sc.nextLine();
        int queryTime = toMinutes(query);

        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > queryTime) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (ans == -1) {
            System.out.println("No train");
        } else {
            int h = times[ans] / 60;
            int m = times[ans] % 60;
            System.out.printf("%02d:%02d\n", h, m);
        }
    }

    static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
/*
 * Time Complexity: O(log n)
 * 說明：使用二分搜尋法在已排序陣列中找第一個大於 queryTime 的時間。
 */
