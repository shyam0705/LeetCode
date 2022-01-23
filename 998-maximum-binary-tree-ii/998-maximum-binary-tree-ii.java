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
    public TreeNode recur(TreeNode root,int val)
    {
        if(root==null)
        {
            return new TreeNode(val);
        }
        
        if(root.val<val)
        {
            TreeNode new_root=new TreeNode(val);
            new_root.left=root;
            return new_root;
        }
        else
        {
            root.right=recur(root.right,val);
            return root;
        }
    }
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        return recur(root,val);
    }
}