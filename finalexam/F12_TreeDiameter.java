import java.util.*;

public class F12_TreeDiameter {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static int maxDiameter = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        String[] nodeStrs = sc.nextLine().trim().split("\\s+");
        List<Integer> nodes = new ArrayList<>();
        for (String s : nodeStrs) {
            nodes.add(Integer.parseInt(s));
        }

        TreeNode root = buildTree(nodes);
        maxDiameter = 0;
        height(root);

        System.out.println(maxDiameter);

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

    
    static int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

       
        int diameterThroughNode = leftHeight + rightHeight + 1;

        if (diameterThroughNode > maxDiameter) {
            maxDiameter = diameterThroughNode;
        }

        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
