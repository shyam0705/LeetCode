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
    public int recur(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=recur(root.left);
        int right=recur(root.right);
        sum=sum+Math.abs(left-right);
        return left+right+root.val;
    }
    public int findTilt(TreeNode root) {
        sum=0;
        recur(root);
        return sum;
    }
}