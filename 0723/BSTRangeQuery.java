import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

public class BSTRangeQuery {

 
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    
    public static ArrayList<Integer> rangeQuery(TreeNode root, int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrderRange(root, min, max, result);
        return result;
    }

    
    private static void inOrderRange(TreeNode node, int min, int max, ArrayList<Integer> result) {
        if (node == null) return;

        
        if (node.val > min) {
            inOrderRange(node.left, min, max, result);
        }

 
        if (node.val >= min && node.val <= max) {
            result.add(node.val);
        }

  
        if (node.val < max) {
            inOrderRange(node.right, min, max, result);
        }
    }


    public static void main(String[] args) {
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        TreeNode root = null;
        for (int v : values) {
            root = insert(root, v);
        }

        int min = 12, max = 27;
        ArrayList<Integer> result = rangeQuery(root, min, max);
        System.out.println("在範圍 [" + min + ", " + max + "] 內的節點值：" + result);
    }
}
