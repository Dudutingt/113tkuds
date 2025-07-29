import java.util.*;

public class F11_BSTClosestValue {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        String[] nodeStrs = sc.nextLine().trim().split("\\s+");
        List<Integer> nodes = new ArrayList<>();
        for (String s : nodeStrs) {
            nodes.add(Integer.parseInt(s));
        }

        
        int target = Integer.parseInt(sc.nextLine().trim());

        TreeNode root = buildTree(nodes);
        int closest = findClosestValue(root, target);
        System.out.println(closest);

        sc.close();
    }

    static TreeNode buildTree(List<Integer> nodes) {
        if (nodes.isEmpty() || nodes.get(0) == -1) return null;
        TreeNode root = new TreeNode(nodes.get(0));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int idx = 1;

        while (idx < nodes.size()) {
            TreeNode curr = q.poll();

            if (idx < nodes.size()) {
                int leftVal = nodes.get(idx++);
                if (leftVal != -1) {
                    curr.left = new TreeNode(leftVal);
                    q.offer(curr.left);
                }
            }
            if (idx < nodes.size()) {
                int rightVal = nodes.get(idx++);
                if (rightVal != -1) {
                    curr.right = new TreeNode(rightVal);
                    q.offer(curr.right);
                }
            }
        }
        return root;
    }

    static int findClosestValue(TreeNode root, int target) {
        int closest = root.val;
        TreeNode node = root;

        while (node != null) {
            int diffNode = Math.abs(node.val - target);
            int diffClosest = Math.abs(closest - target);

            if (diffNode < diffClosest || (diffNode == diffClosest && node.val < closest)) {
                closest = node.val;
            }

            if (target < node.val) {
                node = node.left;
            } else if (target > node.val) {
                node = node.right;
            } else {
                break;  
            }
        }
        return closest;
    }
}
