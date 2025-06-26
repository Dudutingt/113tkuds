import java.util.Random;

public class ds_06 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];
        int max = Integer.MIN_VALUE;

        System.out.print("隨機陣列內容：");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100); // 0~99
            System.out.print(numbers[i] + " ");
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println("\n最大值為：" + max);
    }
}
