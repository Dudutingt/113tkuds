import java.util.Scanner;

public class F05_LCMRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = gcdSubtract(a, b);
        int lcm = a * b / gcd;

        System.out.println("LCM: " + lcm);

        sc.close();
    }

    
    public static int gcdSubtract(int a, int b) {
        if (a == b) {
            return a;
        } else if (a > b) {
            return gcdSubtract(a - b, b);
        } else {
            return gcdSubtract(a, b - a);
        }
    }
}
// 時間複雜度：O(max(a, b))
// 最壞情況下，每次遞迴只減 1，因此最多遞迴 max(a, b) 次。

// 空間複雜度：O(max(a, b))
// 遞迴呼叫堆疊深度最多為 max(a, b)，無額外資料結構。
