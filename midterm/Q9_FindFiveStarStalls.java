import java.util.*;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (scores[i] == 5) {
                idx.add(i);
            }
        }

        if (idx.isEmpty()) {
            System.out.println("None");
        } else {
            for (int i = 0; i < idx.size(); i++) {
                System.out.print(idx.get(i));
                if (i < idx.size() - 1) System.out.print(" ");
            }
        }
    }
}
