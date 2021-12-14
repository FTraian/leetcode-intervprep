package interview.btree_zigzag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/787/
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        Stack<TreeNode> initial = new Stack<>();
        initial.add(root);
        List<List<Integer>> result = new ArrayList<>();

        process(initial, true, result);

        return result;
    }

    public void process(Stack<TreeNode> currentLevel, boolean toTheRight, List<List<Integer>> result) {
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        List<Integer> currentLevelValues = new ArrayList<>();
        TreeNode v = currentLevel.pop();
        while(v != null) {
            if(v != null) {
                currentLevelValues.add(v.val);
                if (toTheRight) {
                    nextLevel.push(v.left);
                    nextLevel.push(v.right);
                } else {
                    nextLevel.push(v.right);
                    nextLevel.push(v.left);
                }
            }
            v = currentLevel.isEmpty() ? null: currentLevel.pop();
        }

        result.add(currentLevelValues);
        if(nextLevel.size() > 0) {
            process(nextLevel, !toTheRight, result);
        }
    }
    
}

class TreeNode {
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