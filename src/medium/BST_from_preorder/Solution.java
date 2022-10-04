package medium.BST_from_preorder;


//  Definition for a binary tree node.
  
 
class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }

        return root;
    }

    private void insert(TreeNode root, int val) {
        if (val < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return;
            }
            insert(root.left, val);
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            }
            insert(root.right, val);
        }
    }

    // public TreeNode bstFromPreorder(int[] preorder) {
    //     if (preorder == null || preorder.length == 0) {
    //         return null;
    //     }

    //     TreeNode root = new TreeNode(preorder[0]);
    //     TreeNode current = root;
    //     int i = 1;
        
        
    // }

    // private TreeNode bstFromPreorder(int[] preoder, int rootIdx, TreeNode root) {
    //     if (preoder[rootIdx + 1] < root.val) {
    //         TreeNode left = new TreeNode(preoder[rootIdx + 1]);
    //         root.left = left;
    //         rootIdx++;
    //     }
    //     if (rootIdx + 1 < preoder.length) {
    //         TreeNode right = new TreeNode(preoder[rootIdx + 1]);
    //         root.right = right;
    //         rootIdx++;
    //     }
    // }


    private class TreeNode {
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
