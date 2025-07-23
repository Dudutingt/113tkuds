public class TreeComparison {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    
    public static boolean isSubtree(TreeNode mainTree, TreeNode subTree) {
        if (subTree == null) return true;
        if (mainTree == null) return false;
        if (isSameTree(mainTree, subTree)) return true;
        return isSubtree(mainTree.left, subTree) || isSubtree(mainTree.right, subTree);
    }

    
    public static TreeNode maxCommonSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return null;
        if (isSameTree(root1, root2)) return root1;

        TreeNode left = maxCommonSubtree(root1.left, root2);
        TreeNode right = maxCommonSubtree(root1.right, root2);

        if (left != null) return left;
        return right;
    }

   
    public static void main(String[] args) {
      
        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(4);
        tree1.right = new TreeNode(5);
        tree1.left.left = new TreeNode(1);
        tree1.left.right = new TreeNode(2);

        TreeNode tree2 = new TreeNode(4);
        tree2.left = new TreeNode(1);
        tree2.right = new TreeNode(2);

        System.out.println("樹1與樹2是否完全相同？ " + isSameTree(tree1, tree2));
        System.out.println("樹2是否為樹1的子樹？ " + isSubtree(tree1, tree2));

        TreeNode common = maxCommonSubtree(tree1, tree2);
        System.out.println("最大公共子樹根節點值: " + (common != null ? common.val : "無"));
    }
}
