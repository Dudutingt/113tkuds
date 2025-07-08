public class GradeProcessor {
    public static void main(String[] args) {
        
        int[] scores = {78, 85, 92, 67, 88, 95, 73, 90};

        
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double avg = (double) sum / scores.length;
        System.out.printf("總分: %d\n", sum);
        System.out.printf("平均分數: %.2f\n", avg);

        
        int max = scores[0], min = scores[0];
        int maxIdx = 0, minIdx = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
                maxIdx = i;
            }
            if (scores[i] < min) {
                min = scores[i];
                minIdx = i;
            }
        }
        System.out.printf("最高分: %d (索引: %d)\n", max, maxIdx);
        System.out.printf("最低分: %d (索引: %d)\n", min, minIdx);

       
        int countAboveAvg = 0;
        for (int score : scores) {
            if (score > avg) countAboveAvg++;
        }
        System.out.printf("超過平均分的人數: %d\n", countAboveAvg);

        
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("學生編號%d: %d\n", i, scores[i]);
        }
    }
}
