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
    int sum;
    public void recur(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        if(root.left!=null)
        {
            if(root.left.left==null && root.left.right==null)
            {
                sum+=root.left.val;
                recur(root.right);
                return;
            }
        }
        recur(root.left);
        recur(root.right);
        return;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        sum=0;
        recur(root);
        return sum;
    }
}