

public class array_sum_trace {
    public static void main(String[] args) {
        int[] arr ={1,3,5};
        int total=0;
        for(int i=0;i<=arr.length;i++){
            System.out.println("加總過程;total="+total+"+"+arr[i]+"="+(total=arr[i]));
            total+=arr[i];


        }System.out.println("總和為:"+total);
    } 
}
//此演算法會走訪陣列中每一個元素一次，因此其時間複雜度為 O(n)，其中 n 是陣列的長度。