public class ArraySumExample {
    
    public static int arraySum(int[] arr, int index) {
        
        if (index >= arr.length) {
            return 0;
        }
        
        return arr[index] + arraySum(arr, index + 1);
    }
    
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("陣列總和: " + arraySum(numbers, 0)); // 輸出：15
        
        int[] moreNumbers = {10, 20, 30};
        System.out.println("陣列總和: " + arraySum(moreNumbers, 0)); // 輸出：60
    }
}
