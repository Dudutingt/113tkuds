import java.util.Scanner;

public class q3binsearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        int ops = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int key = input.nextInt();
        int left = 0, right = n - 1, index = -1;

        while (left <= right) {
            ops++;
            int mid = (left + right) / 2;
            if (arr[mid] == key) {
                index = mid;
                break;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(index);
        System.out.println(ops);
    }
}
