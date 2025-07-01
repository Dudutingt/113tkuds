public class matrix_multiplication_trace {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int[][] c = new int[2][2];
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("計算位置 c[" + i + "][" + j + "]：");
                int sum = 0;
                StringBuilder expression = new StringBuilder();
                StringBuilder values = new StringBuilder();
                
                for (int k = 0; k < 2; k++) {
                    int product = a[i][k] * b[k][j];
                    sum += product;
                    
                    // 建構運算式
                    if (k > 0) {
                        expression.append(" + ");
                        values.append(" + ");
                    }
                    expression.append(a[i][k]).append("*").append(b[k][j]);
                    values.append(product);
                }
                
                c[i][j] = sum;
                System.out.println(expression + " = " + values + " = " + sum);
            }
        }
        
        System.out.println("結果矩陣：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}
//•	使用三重迴圈（i, j, k）計算矩陣乘法若矩陣大小為 n × n：外層 i 迴圈執行 n 次中層 j 迴圈執行 n 內層 k 迴圈執行 n 次總計算量為 n × n × n = n³	時間複雜度為 O(n³)