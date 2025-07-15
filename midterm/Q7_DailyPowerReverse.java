import java.util.*;

public class Q7_DailyPowerReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] usage = new int[7];
        for (int i = 0; i < 7; i++) {
            usage[i] = sc.nextInt();
        }

        for (int i = 0, j = 6; i < j; i++, j--) {
            int tmp = usage[i];
            usage[i] = usage[j];
            usage[j] = tmp;
        }

        for (int i = 0; i < 7; i++) {
            System.out.print(usage[i]);
            if (i < 6) System.out.print(" ");
        }
    }
}
