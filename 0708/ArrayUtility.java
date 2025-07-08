public class ArrayUtility {
    
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    
    public static void reverseArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    
    public static int[] copyArray(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    
    public static int findSecondLargest(int[] array) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int n : array) {
            if (n > max) {
                secondMax = max;
                max = n;
            } else if (n > secondMax && n < max) {
                secondMax = n;
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {
       
        int[] arr = {3, 7, 1, 9, 4, 6, 8, 2, 5};

        
        System.out.print("原始陣列: ");
        printArray(arr);

        
        reverseArray(arr);
        System.out.print("反轉後陣列: ");
        printArray(arr);

        
        int[] arrCopy = copyArray(arr);
        System.out.print("副本陣列: ");
        printArray(arrCopy);

        
        int secondLargest = findSecondLargest(arr);
        System.out.println("第二大數值: " + secondLargest);
    }
}
