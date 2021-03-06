package hard.lowest_common_ancestor;

import java.util.LinkedList;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pathP = findPath(root, p);
        LinkedList<TreeNode> pathQ = findPath(root, q);
        TreeNode currentP = pathP.peekLast();
        TreeNode currentQ = pathQ.peekLast();
        TreeNode last = currentP;

        while (currentP == currentQ) {
            last = currentP;
            currentP = pathP.pollLast();
            currentQ = pathQ.pollLast();
        }

        return last;
    }

    private LinkedList<TreeNode> findPath(TreeNode current, TreeNode destination) {
        if (current.val == destination.val) {
            LinkedList<TreeNode> result = new LinkedList<>();
            result.add(current);
            return result;
        }
        if (current.left != null) {
            LinkedList<TreeNode> pathLeft = findPath(current.left, destination);
            if (pathLeft != null) {
                pathLeft.add(current);
                return pathLeft;
            }
        }
        if (current.right != null) {
            LinkedList<TreeNode> pathRight = findPath(current.right, destination);
            if (pathRight != null) {
                pathRight.add(current);
                return pathRight;
            }
        }
        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}