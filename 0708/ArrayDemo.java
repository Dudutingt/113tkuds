public class ArrayDemo {
    public static void main(String[] args) {
        double [] numbers={1.3,2.31,3.15,4.76,5.84};
        for (int i=0;i < numbers.length;i++){
            System.out.println(numbers[i]);
            System.out.println("Index:"+i);
            System.out.println("佔用記憶體:"+(Integer.BYTES+"bytes"));
        }
    }
}
