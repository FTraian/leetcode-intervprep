package fb.bst_iterator;

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 *
 */
class BSTIterator {

    private final TreeNode root;
    private LinkedList<TreeNode> sorted;

    public BSTIterator(TreeNode root) {
        this.root = root;
        sorted = sort(root);
    }

    private LinkedList<TreeNode> sort(TreeNode node) {
        LinkedList<TreeNode> result = new LinkedList<>();
        if (node.left != null) {
            result.addAll(sort(node.left));
        }
        result.add(node);
        if (node.right != null) {
            result.addAll(sort(node.right));
        }

        return result;
    }

    public int next() {
        return sorted.removeFirst().val;
    }

    public boolean hasNext() {
        return !sorted.isEmpty();
    }

    static class TreeNode {
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

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

