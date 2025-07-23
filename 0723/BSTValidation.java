import java.util.*;

public class BSTValidation {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    
    public static List<Integer> findInvalidNodes(TreeNode root) {
        List<Integer> invalids = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        inOrder(root, inorder);
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i) <= inorder.get(i - 1)) {
                invalids.add(inorder.get(i));
            }
        }
        return invalids;
    }

    private static void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    public static int nodesToRemoveForValidBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inOrder(root, inorder);
        int lis = lengthOfLIS(inorder);
        return inorder.size() - lis;
    }

    private static int lengthOfLIS(List<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums.get(i) > nums.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    
    public static void main(String[] args) {
      
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(12);  
        root.right.right = new TreeNode(20);

        System.out.println("是否為合法BST? " + isValidBST(root));
        System.out.println("不合法節點列表: " + findInvalidNodes(root));
        System.out.println("需移除節點數: " + nodesToRemoveForValidBST(root));
    }
}
