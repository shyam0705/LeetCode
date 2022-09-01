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
    int count=0;
    public void recur(TreeNode root,int max)
    {
        if(root==null)
            return;
        if(root.val>=max)
        {
            count++;
            
        }
        recur(root.left,Math.max(root.val,max));
        recur(root.right,Math.max(root.val,max));
    }
    public int goodNodes(TreeNode root) {
        count=0;
        recur(root,Integer.MIN_VALUE);
        return count;
    }
}