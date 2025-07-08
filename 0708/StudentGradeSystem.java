public class StudentGradeSystem {
    
    public static String getGrade(int score) {
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else return "D";
    }

    
    public static void printReport(int[] scores, String[] grades) {
        System.out.println("學生分數等級報告");
        System.out.println("============================================");
        System.out.printf("%-6s %-6s %-6s\n", "編號", "分數", "等級");
        System.out.println("--------------------------------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-6d %-6d %-6s\n", i, scores[i], grades[i]);
        }
        System.out.println("============================================");
    }

    public static void main(String[] args) {
        
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};
        int n = scores.length;
        String[] grades = new String[n];

        
        int countA = 0, countB = 0, countC = 0, countD = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            grades[i] = getGrade(scores[i]);
            sum += scores[i];
            switch (grades[i]) {
                case "A": countA++; break;
                case "B": countB++; break;
                case "C": countC++; break;
                case "D": countD++; break;
            }
        }
        double avg = (double)sum / n;

        
        int max = scores[0], min = scores[0];
        int maxIdx = 0, minIdx = 0;
        for (int i = 1; i < n; i++) {
            if (scores[i] > max) {
                max = scores[i];
                maxIdx = i;
            }
            if (scores[i] < min) {
                min = scores[i];
                minIdx = i;
            }
        }

        
        int countAboveAvg = 0;
        for (int s : scores) if (s > avg) countAboveAvg++;
        double ratio = (double)countAboveAvg / n * 100;

        
        System.out.println("學生分數等級統計系統");
        System.out.println("============================================");
        System.out.printf("總人數：%d\n", n);
        System.out.printf("平均分：%.2f\n", avg);
        System.out.printf("A 等級人數：%d\n", countA);
        System.out.printf("B 等級人數：%d\n", countB);
        System.out.printf("C 等級人數：%d\n", countC);
        System.out.printf("D 等級人數：%d\n", countD);
        System.out.printf("最高分：%d (編號: %d)\n", max, maxIdx);
        System.out.printf("最低分：%d (編號: %d)\n", min, minIdx);
        System.out.printf("高於平均分人數：%d (比例：%.1f%%)\n", countAboveAvg, ratio);
        System.out.println("============================================");

        
        printReport(scores, grades);
    }
}
