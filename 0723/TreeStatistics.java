
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class TreeStatistics {
    TreeNode root;

    public TreeStatistics(TreeNode root) {
        this.root = root;
    }

   
    public int sum(TreeNode node) {
        if (node == null) return 0;
        return node.val + sum(node.left) + sum(node.right);
    }

    // 2. 最大值
    public int max(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        return Math.max(node.val, Math.max(max(node.left), max(node.right)));
    }

    // 3. 最小值
    public int min(TreeNode node) {
        if (node == null) return Integer.MAX_VALUE;
        return Math.min(node.val, Math.min(min(node.left), min(node.right)));
    }

    public int countLeaves(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }


    public int depth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(depth(node.left), depth(node.right));
    }

   
    public static void main(String[] args) {
      
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(25);

        TreeStatistics stats = new TreeStatistics(root);
        System.out.println("節點總和: " + stats.sum(root));           
        System.out.println("最大值: " + stats.max(root));               
        System.out.println("最小值: " + stats.min(root));              
        System.out.println("葉節點數量: " + stats.countLeaves(root));  
        System.out.println("樹的深度: " + stats.depth(root));           
    }
}
