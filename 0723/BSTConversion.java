
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}


class ListNode {
    int val;
    ListNode prev, next;
    ListNode(int val) {
        this.val = val;
    }
}

public class BSTConversion {

    public static ListNode bstToSortedDoublyList(TreeNode root) {
        
        ListNode[] headTail = new ListNode[2]; 
        bstToListHelper(root, headTail);
        return headTail[0];
    }
    private static void bstToListHelper(TreeNode node, ListNode[] headTail) {
        if (node == null) return;
        
        bstToListHelper(node.left, headTail);
        
        ListNode curr = new ListNode(node.val);
        if (headTail[1] != null) {
            headTail[1].next = curr;
            curr.prev = headTail[1];
        } else {
            headTail[0] = curr; 
        }
        headTail[1] = curr; 
       
        bstToListHelper(node.right, headTail);
    }

    // 2. 將排序陣列轉換為平衡的BST
    // 類似Leetcode 108
    public static TreeNode sortedArrayToBST(int[] arr) {
        return sortedArrayToBSTHelper(arr, 0, arr.length - 1);
    }
    private static TreeNode sortedArrayToBSTHelper(int[] arr, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = sortedArrayToBSTHelper(arr, start, mid - 1);
        root.right = sortedArrayToBSTHelper(arr, mid + 1, end);
        return root;
    }

    public static void convertBSTtoGreaterSum(TreeNode root) {
        int[] sum = new int[1];
        convertBSTtoGreaterSumHelper(root, sum);
    }
    private static void convertBSTtoGreaterSumHelper(TreeNode node, int[] sum) {
        if (node == null) return;
        
        convertBSTtoGreaterSumHelper(node.right, sum);
        
        sum[0] += node.val;
        node.val = sum[0];
        
        convertBSTtoGreaterSumHelper(node.left, sum);
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" <-> ");
            curr = curr.next;
        }
        System.out.println();
    }

    
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

  
    public static void main(String[] args) {
      
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        ListNode head = bstToSortedDoublyList(root);
        System.out.println("BST 轉排序雙向鏈表:");
        printList(head);

       
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode bst = sortedArrayToBST(arr);
        System.out.print("排序陣列轉平衡BST (in-order): ");
        printInOrder(bst);
        System.out.println();

        
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(7);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(8);
        convertBSTtoGreaterSum(root2);
        System.out.print("BST每節點作greater sum (in-order): ");
        printInOrder(root2);
        System.out.println();
    }
}
