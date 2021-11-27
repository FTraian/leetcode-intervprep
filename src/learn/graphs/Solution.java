package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        if (root.left != null) acc.addAll(preorderTraversal(root.left));
        if (root.right != null) acc.addAll(preorderTraversal(root.right));
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
