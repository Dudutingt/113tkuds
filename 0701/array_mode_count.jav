public class array_mode_count {
    public static void main(String[] args) {
        int[] arr = {3, 7, 3, 1, 1, 1};

        int mode = arr[0];      
        int maxCount = 0;       

        for (int i = 0; i < arr.length; i++) {
            int count = 0;

         
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

           
            System.out.println("比對中：" + arr[i] + " 出現次數 = " + count);

          
            if (count > maxCount) {
                maxCount = count;
                mode = arr[i];
            }
        }

        System.out.println("眾數為：" + mode + "，出現 " + maxCount + " 次");
    }
}
//可以改善。如果允許使用 HashMap（雜湊表），可以將每個元素的出現次數記錄起來，僅需一次走訪 這樣的總時間複雜度就會是 O(n)，比 O(n²) 更有效率