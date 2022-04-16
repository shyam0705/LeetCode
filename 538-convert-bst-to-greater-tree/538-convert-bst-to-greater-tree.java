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
    public int recur(TreeNode root,int sum)
    {
        if(root==null)
        {
            return 0;
        }
        if(root.right==null)
        {
            root.val=root.val+sum;
        
        }
        else
        {
            root.val=root.val+recur(root.right,sum);
            
        }
        if(root.left==null)
        {
            return root.val;
        }
        return recur(root.left,root.val);
    }
    public TreeNode convertBST(TreeNode root) {
        recur(root,0);
        return root;
    }
}