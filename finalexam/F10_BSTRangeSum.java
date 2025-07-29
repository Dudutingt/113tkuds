import java.util.*;

public class F10_BSTRangeSum {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        List<Integer> nodes = new ArrayList<>();
        while (sc.hasNextInt()) {
            nodes.add(sc.nextInt());
            if (sc.hasNextLine() == false) break;
        }

        
        TreeNode root = buildTree(nodes);

        
        int L = sc.nextInt();
        int R = sc.nextInt();

        int sum = rangeSumBST(root, L, R);

        System.out.println(sum);

        sc.close();
    }

    static TreeNode buildTree(List<Integer> nodes) {
        if (nodes.isEmpty() || nodes.get(0) == -1) return null;

        TreeNode root = new TreeNode(nodes.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int idx = 1;
        while (idx < nodes.size()) {
            TreeNode current = queue.poll();

            // 左子
            if (idx < nodes.size()) {
                int leftVal = nodes.get(idx++);
                if (leftVal != -1) {
                    current.left = new TreeNode(leftVal);
                    queue.offer(current.left);
                }
            }

            // 右子
            if (idx < nodes.size()) {
                int rightVal = nodes.get(idx++);
                if (rightVal != -1) {
                    current.right = new TreeNode(rightVal);
                    queue.offer(current.right);
                }
            }
        }

        return root;
    }

    static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;

        if (root.val < L) {
           
            return rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            
            return rangeSumBST(root.left, L, R);
        } else {
            
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
    }
}
