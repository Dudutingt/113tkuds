import java.util.*;

public class TreeDistance {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
    public static int distanceFromRoot(TreeNode root, TreeNode p, int dist) {
        if (root == null) return -1;
        if (root == p) return dist;
        int left = distanceFromRoot(root.left, p, dist + 1);
        if (left != -1) return left;
        return distanceFromRoot(root.right, p, dist + 1);
    }

    public static int distanceBetweenNodes(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = lowestCommonAncestor(root, p, q);
        int distP = distanceFromRoot(lca, p, 0);
        int distQ = distanceFromRoot(lca, q, 0);
        return distP + distQ;
    }

    private static int[] diameterHelper(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int[] left = diameterHelper(node.left);
        int[] right = diameterHelper(node.right);

        int height = Math.max(left[0], right[0]) + 1;
        int maxDiameter = Math.max(left[0] + right[0], Math.max(left[1], right[1]));
        return new int[]{height, maxDiameter};
    }

    public static int diameter(TreeNode root) {
        return diameterHelper(root)[1];
    }

    // 3. 找距離根節點指定距離的所有節點
    public static List<Integer> nodesAtDistance(TreeNode root, int distance) {
        List<Integer> result = new ArrayList<>();
        nodesAtDistanceHelper(root, distance, result);
        return result;
    }

    private static void nodesAtDistanceHelper(TreeNode node, int dist, List<Integer> res) {
        if (node == null) return;
        if (dist == 0) {
            res.add(node.val);
            return;
        }
        nodesAtDistanceHelper(node.left, dist -1, res);
        nodesAtDistanceHelper(node.right, dist -1, res);
    }

  
    public static void main(String[] args) {
       
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);

        System.out.println("節點4與節點7的距離: " +
            distanceBetweenNodes(root, root.left.left, root.right.right.left));

        System.out.println("樹的直徑: " + diameter(root));

        int dist = 2;
        System.out.println("距離根節點" + dist + "的節點有: " + nodesAtDistance(root, dist));
    }
}
