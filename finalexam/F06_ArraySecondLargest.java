import java.util.Scanner;

public class F06_ArraySecondLargest {

    
    static class Pair {
        int max;
        int second;

        Pair(int max, int second) {
            this.max = max;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Pair result = findMaxSecond(arr, 0, n - 1);
        System.out.println("SecondMax: " + result.second);

        sc.close();
    }

    
    public static Pair findMaxSecond(int[] arr, int left, int right) {
        if (left == right) {
            return new Pair(arr[left], Integer.MIN_VALUE);
        }

        int mid = (left + right) / 2;

        Pair leftPair = findMaxSecond(arr, left, mid);
        Pair rightPair = findMaxSecond(arr, mid + 1, right);

        int max, second;

        if (leftPair.max > rightPair.max) {
            max = leftPair.max;
            second = Math.max(leftPair.second, rightPair.max);
        } else if (leftPair.max < rightPair.max) {
            max = rightPair.max;
            second = Math.max(rightPair.second, leftPair.max);
        } else {
            max = leftPair.max; 
            second = Math.max(leftPair.second, rightPair.second);
        }

        return new Pair(max, second);
    }
}
// 時間複雜度：O(n)
// 每個元素只處理一次，並在合併時進行最多 2 次比較。

// 空間複雜度：O(log n)
// 使用遞迴呼叫堆疊，最深遞迴深度為 log₂(n)。
