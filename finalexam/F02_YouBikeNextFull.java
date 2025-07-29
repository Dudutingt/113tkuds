import java.util.Scanner;

public class F02_YouBikeNextFull {
    
    public static int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 60 + minute;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] timeList = new String[n];
        int[] minuteList = new int[n];

        for (int i = 0; i < n; i++) {
            timeList[i] = sc.nextLine();
            minuteList[i] = timeToMinutes(timeList[i]);
        }

        String queryTime = sc.nextLine();
        int query = timeToMinutes(queryTime);

        
        int left = 0, right = n - 1;
        int resultIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (minuteList[mid] > query) {
                resultIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (resultIndex == -1) {
            System.out.println("No bike");
        } else {
            System.out.println(timeList[resultIndex]);
        }

        sc.close();
    }
}
// 時間複雜度：O(log n)
// 使用二分搜尋在已排序時間中尋找第一個大於查詢時間的時刻。

// 空間複雜度：O(n)
// 儲存時間字串與對應分鐘值的陣列各需 O(n) 空間。
