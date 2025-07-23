

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BSTRangeSearch {
    TreeNode root;

    
    public TreeNode insert(TreeNode node, int val) {
        if (node == null) return new TreeNode(val);
        if (val < node.val) node.left = insert(node.left, val);
        else node.right = insert(node.right, val);
        return node;
    }

  
    public void rangeSearch(TreeNode node, int low, int high, List<Integer> result) {
        if (node == null) return;
        if (node.val > low) rangeSearch(node.left, low, high, result);
        if (node.val >= low && node.val <= high) result.add(node.val);
        if (node.val < high) rangeSearch(node.right, low, high, result);
    }

    public static void main(String[] args) {
        
        int[] values = {20, 10, 5, 15, 30, 25, 35};
        BSTRangeSearch bst = new BSTRangeSearch();
        for (int val : values) {
            bst.root = bst.insert(bst.root, val);
        }

    
        int low = 10, high = 28;
        List<Integer> result = new ArrayList<>();
        bst.rangeSearch(bst.root, low, high, result);

        System.out.println("在 [" + low + ", " + high + "] 範圍內的節點有：" + result);
       
    }
}
