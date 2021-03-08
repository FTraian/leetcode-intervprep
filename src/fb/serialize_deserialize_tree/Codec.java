package fb.serialize_deserialize_tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        return visitDFS(root).toString();
    }

    private StringBuilder visitDFS(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append(',');
        if (node.left == null) sb.append("null,");
        else sb.append(visitDFS(node.left));
        if (node.right == null) sb.append("null,");
        else sb.append(visitDFS(node.right));
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return visitDeserialize(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    private TreeNode visitDeserialize(List<String> data) {
        if (data.get(0).equals("null")) {
            data.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(data.get(0)));
        data.remove(0);
        root.left = visitDeserialize(data);
        root.right = visitDeserialize(data);

        return root;
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        n3.left = n4;
        n3.right = n5;
        TreeNode n2 = new TreeNode(2);
        TreeNode root = new TreeNode(1);
        root.left = n2;
        root.right = n3;

        String serialize = new Codec().serialize(root);
        TreeNode newRoot = new Codec().deserialize(serialize);
    }
}


class TreeNode {
       int val;
       TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));