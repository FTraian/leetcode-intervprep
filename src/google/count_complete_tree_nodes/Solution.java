package count_complete_tree_nodes;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3071/
 */
public class Solution {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.add(root);
        int level = -1;
        int noInLastLevel = 1;

        while (!currentLevel.isEmpty()) {
            level++;
            noInLastLevel = currentLevel.size();

            List<TreeNode> nextLevel = new LinkedList<>();
            for(TreeNode n: currentLevel) {
                if (n.right != null) nextLevel.add(n.right);
                if (n.left != null) nextLevel.add(n.left);
            }
            currentLevel = nextLevel;
        }

        return (int) (Math.pow(2, level + 2) - 1 - Math.pow(2, level + 1) + noInLastLevel);
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
