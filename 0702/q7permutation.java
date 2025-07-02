import java.util.Scanner;

public class q7permutation {
    static int ops = 0;

    public static void permute(int[] arr, int start) {
        if (start == arr.length) {
            for (int i : arr)
                System.out.print(i + " ");
            System.out.println();
            ops++;
            return;
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, i, start);
            permute(arr, start + 1);
            swap(arr, i, start);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = i + 1;

        permute(arr, 0);
        System.out.println(ops);
    }
}

