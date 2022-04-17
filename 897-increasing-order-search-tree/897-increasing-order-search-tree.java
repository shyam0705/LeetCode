/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode recur(TreeNode root)
    {
        if(root==null)
        {
            return null;
        }
        if(root.left!=null)
        {
            TreeNode tmp=recur(root.left);
            root.left=null;
            TreeNode current=tmp;
            while(current.right!=null)
            {
                current=current.right;
            }
            current.right=root;
            root.right=recur(root.right);
            return tmp;
        }
        root.right=recur(root.right);
        return root;
       
    }
    public TreeNode increasingBST(TreeNode root) {
        return recur(root);
    }
}