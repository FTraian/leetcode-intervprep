package invert_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionInvert {

    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> toVisit = new LinkedList<>();
        toVisit.add(root);

        TreeNode node = toVisit.poll();
        do {
            if (node != null) {
                swapChildren(node);
                toVisit.add(node.left);
                toVisit.add(node.right);
            }
            node = toVisit.poll();
        } while ( !(node == null && toVisit.isEmpty()));
        return root;
    }

    private void swapChildren(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(3, new TreeNode(1, null, null), null), null );
        new SolutionInvert().invertTree(root);
    }

    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
}
