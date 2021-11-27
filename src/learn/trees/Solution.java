package trees;

import java.util.*;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.add(root.val);
            if (root.left != null) result.addAll(preorderTraversal(root.left));
            if (root.right != null) result.addAll(preorderTraversal(root.right));
        }
        return result;
    }

    public List<Integer> preorderTraversalV2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root != null) {
            preorderTraversalWithAccumulator(root, result);
        }
        return result;
    }

    public void preorderTraversalWithAccumulator(TreeNode root, List<Integer> acc) {
        acc.add(root.val);
        if (root.left != null) preorderTraversalWithAccumulator(root.left, acc);
        if (root.right != null) preorderTraversalWithAccumulator(root.right, acc);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> result = new LinkedList<>();
        List<TreeNode> visitQ = new LinkedList<>();
        visitQ.add(root);

        while (!visitQ.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>(visitQ.size());
            List<TreeNode> nextLevel = new LinkedList<>();
            for (TreeNode node: visitQ) {
                currentLevel.add(node.val);
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }
            result.add(currentLevel);
            visitQ = nextLevel;
        }

        return result;
    }

    public class TreeNode {
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
