public class BSTBalance {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static class BalanceStatus {
        boolean isBalanced;
        int height;
        int maxImbalance;
        TreeNode mostImbalancedNode;

        BalanceStatus(boolean isBalanced, int height, int maxImbalance, TreeNode node) {
            this.isBalanced = isBalanced;
            this.height = height;
            this.maxImbalance = maxImbalance;
            this.mostImbalancedNode = node;
        }
    }

    
    public static BalanceStatus checkBalance(TreeNode root) {
        if (root == null) return new BalanceStatus(true, 0, 0, null);

        BalanceStatus left = checkBalance(root.left);
        BalanceStatus right = checkBalance(root.right);

        boolean isBalanced = left.isBalanced && right.isBalanced &&
                Math.abs(left.height - right.height) <= 1;
        int height = Math.max(left.height, right.height) + 1;
        int balanceFactor = left.height - right.height;

        
        int maxImbalance = Math.abs(balanceFactor);
        TreeNode mostImbalancedNode = root;

        if (left.maxImbalance > maxImbalance) {
            maxImbalance = left.maxImbalance;
            mostImbalancedNode = left.mostImbalancedNode;
        }
        if (right.maxImbalance > maxImbalance) {
            maxImbalance = right.maxImbalance;
            mostImbalancedNode = right.mostImbalancedNode;
        }

        return new BalanceStatus(isBalanced, height, maxImbalance, mostImbalancedNode);
    }

    
    public static int balanceFactor(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return leftHeight - rightHeight;
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static void main(String[] args) {
   
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.right.right = new TreeNode(20);
        root.right.right.right = new TreeNode(25);

        BalanceStatus status = checkBalance(root);
        System.out.println("是否為平衡樹: " + status.isBalanced);
        System.out.println("樹高度: " + status.height);
        System.out.println("最不平衡節點值: " + (status.mostImbalancedNode != null ? status.mostImbalancedNode.val : "無"));
        if (status.mostImbalancedNode != null) {
            System.out.println("該節點平衡因子: " + balanceFactor(status.mostImbalancedNode));
        }
    }
}
