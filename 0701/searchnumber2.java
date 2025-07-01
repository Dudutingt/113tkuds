import java.util.Scanner;

public class searchnumber2 {
  
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid; 
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int[] s = {1, 3, 5, 7, 9, 11, 13}; 
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入要比對幾次：");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("請輸入第 " + i + " 次要找的數字：");
            int x = scanner.nextInt();
            int result = binarySearch(s, x);
            if (result != -1) {
                System.out.println("第 " + i + " 次搜尋成功（索引：" + result + "）");
            } else {
                System.out.println("第 " + i + " 次搜尋失敗！");
            }
        }
    }
}
