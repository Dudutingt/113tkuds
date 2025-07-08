public class ArraySearcher {
    
    public static int findElement(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    
    public static int countOccurrences(int[] array, int target) {
        int count = 0;
        for (int num : array) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        
        int[] arr = {12, 45, 23, 67, 34, 89, 56, 78, 91, 25};

       
        int target1 = 67;
        int target2 = 100;

        int idx1 = findElement(arr, target1);
        int count1 = countOccurrences(arr, target1);

        int idx2 = findElement(arr, target2);
        int count2 = countOccurrences(arr, target2);

        System.out.println("搜尋數字 " + target1 + "：索引 = " + idx1 + "，出現次數 = " + count1);
        System.out.println("搜尋數字 " + target2 + "：索引 = " + idx2 + "，出現次數 = " + count2);
    }
}
