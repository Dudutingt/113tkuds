public class runc {
    public static void main(String[] args) {
        int n = 10; 
        int x = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                x = x + 1;
            }
        }
        System.out.println("(c) x = x + 1 執行次數: " + x);
    }
}
