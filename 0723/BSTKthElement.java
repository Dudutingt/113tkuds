public class BSTKthElement {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static int count = 0;
    static int result = -1;

    
    public static void kthSmallest(TreeNode root, int k) {
        if (root == null) return;

        kthSmallest(root.left, k);

        count++;
        if (count == k) {
            result = root.val;
            return;
        }

        kthSmallest(root.right, k);
    }

    
    public static int findKthSmallest(TreeNode root, int k) {
        count = 0;
        result = -1;
        kthSmallest(root, k);
        return result;
    }

    
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        for (int k = 1; k <= 7; k++) {
            System.out.println("第 " + k + " 小元素是: " + findKthSmallest(root, k));
        }
    }
}
