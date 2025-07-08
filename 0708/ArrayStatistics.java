public class ArrayStatistics {
    public static void main(String[] args) {
        int[] arr = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        
        int sum = 0;
        for (int n : arr) sum += n;
        double avg = (double) sum / arr.length;

        
        int max = arr[0], min = arr[0];
        int maxIdx = 0, minIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIdx = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                minIdx = i;
            }
        }

        
        int countAboveAvg = 0;
        for (int n : arr) if (n > avg) countAboveAvg++;

        
        int even = 0, odd = 0;
        for (int n : arr) {
            if (n % 2 == 0) even++;
            else odd++;
        }

        
        String line = "+----------------------+---------------------+";
        System.out.println(line);
        System.out.printf("| %-20s | %-19s |\n", "統計項目", "結果");
        System.out.println(line);
        System.out.printf("| %-20s | %-19d |\n", "總和", sum);
        System.out.printf("| %-20s | %-19.2f |\n", "平均值", avg);
        System.out.printf("| %-20s | %-10d(索引:%-3d) |\n", "最大值", max, maxIdx);
        System.out.printf("| %-20s | %-10d(索引:%-3d) |\n", "最小值", min, minIdx);
        System.out.printf("| %-20s | %-19d |\n", "大於平均值的個數", countAboveAvg);
        System.out.printf("| %-20s | %-19d |\n", "偶數個數", even);
        System.out.printf("| %-20s | %-19d |\n", "奇數個數", odd);
        System.out.println(line);
    }
}
