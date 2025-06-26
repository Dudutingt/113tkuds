public class 2 {import java.util.Scanner;

public class HelloUser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入你的名字：");
        String name = scanner.nextLine();

        System.out.println("你好，" + name + "！歡迎使用 Java 程式。");

        scanner.close();
    }
}

    
}
