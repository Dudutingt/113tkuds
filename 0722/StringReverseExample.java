public class StringReverseExample {
    
    public static String reverseString(String str) {
        
        if (str.length() <= 1) {
            return str;
        }
        
        return str.charAt(str.length() - 1) + 
               reverseString(str.substring(0, str.length() - 1));
    }
    
    public static void main(String[] args) {
        System.out.println("反轉 'hello': " + reverseString("hello")); 
        System.out.println("反轉 'java': " + reverseString("java"));   
        System.out.println("反轉 'a': " + reverseString("a"));         
    }
}
