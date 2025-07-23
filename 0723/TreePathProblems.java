import java.util.*;

public class TreePathProblems {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    
    public static List<List<Integer>> allRootToLeafPaths(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, new ArrayList<>(), res);
        return res;
    }

    private static void dfs(TreeNode node, List<Integer> path, List<List<Integer>> res) {
        if (node == null) return;
        path.add(node.val);
        if (node.left == null && node.right == null) {
            res.add(new ArrayList<>(path));
        } else {
            dfs(node.left, path, res);
            dfs(node.right, path, res);
        }
        path.remove(path.size() - 1);
    }

   
    public static boolean hasPathSum(TreeNode root, int target) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == target;
        return hasPathSum(root.left, target - root.val) || hasPathSum(root.right, target - root.val);
    }


    public static int maxRootToLeafSum(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        if (root.left == null && root.right == null) return root.val;
        int leftSum = maxRootToLeafSum(root.left);
        int rightSum = maxRootToLeafSum(root.right);
        return root.val + Math.max(leftSum, rightSum);
    }

    
    public static void main(String[] args) {
       
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(15);

        System.out.println("所有根到葉路徑:");
        List<List<Integer>> paths = allRootToLeafPaths(root);
        for (List<Integer> path : paths) {
            System.out.println(path);
        }

        int target = 22;
        System.out.println("是否存在根到葉路徑和為 " + target + "? " + hasPathSum(root, target));

        System.out.println("根到葉最大路徑和: " + maxRootToLeafSum(root));
    }
}
