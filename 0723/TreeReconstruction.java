import java.util.*;

public class TreeReconstruction {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    
    public static TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildPreIn(preorder, 0, preorder.length -1, inorder, 0, inorder.length -1, inorderMap);
    }

    private static TreeNode buildPreIn(int[] preorder, int preStart, int preEnd,
                                       int[] inorder, int inStart, int inEnd,
                                       Map<Integer, Integer> inorderMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inRootIndex = inorderMap.get(rootVal);
        int leftTreeSize = inRootIndex - inStart;

        root.left = buildPreIn(preorder, preStart +1, preStart + leftTreeSize,
                              inorder, inStart, inRootIndex -1, inorderMap);
        root.right = buildPreIn(preorder, preStart + leftTreeSize +1, preEnd,
                               inorder, inRootIndex +1, inEnd, inorderMap);
        return root;
    }

    
    public static TreeNode buildTreePostIn(int[] postorder, int[] inorder) {
        if (postorder == null || inorder == null || postorder.length != inorder.length) return null;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildPostIn(postorder, 0, postorder.length -1, inorder, 0, inorder.length -1, inorderMap);
    }

    private static TreeNode buildPostIn(int[] postorder, int postStart, int postEnd,
                                        int[] inorder, int inStart, int inEnd,
                                        Map<Integer, Integer> inorderMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int inRootIndex = inorderMap.get(rootVal);
        int leftTreeSize = inRootIndex - inStart;

        root.left = buildPostIn(postorder, postStart, postStart + leftTreeSize -1,
                              inorder, inStart, inRootIndex -1, inorderMap);
        root.right = buildPostIn(postorder, postStart + leftTreeSize, postEnd -1,
                               inorder, inRootIndex +1, inEnd, inorderMap);
        return root;
    }

    
    public static void printPreOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        TreeNode rootFromPreIn = buildTreePreIn(preorder, inorder);
        System.out.print("前序+中序重建樹的前序遍歷: ");
        printPreOrder(rootFromPreIn);
        System.out.println();

        TreeNode rootFromPostIn = buildTreePostIn(postorder, inorder);
        System.out.print("後序+中序重建樹的前序遍歷: ");
        printPreOrder(rootFromPostIn);
        System.out.println();
    }
}
