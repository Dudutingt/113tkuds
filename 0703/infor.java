import java.util.*;

public class infor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            lines.add(line);
        }
        for (String s : lines) {
            System.out.println(s);
        }
    }
}
