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
    public void recur(TreeNode root,int l,int h)
    {
        if(root==null)
        {
            return;
        }
        if(root.val>=l && root.val<=h)
        {
            sum=sum+root.val;
            recur(root.left,l,h);
            recur(root.right,l,h);
        }
        else if(root.val<l)
        {
            recur(root.right,l,h);
        }
        else
        {
            recur(root.left,l,h);
        }
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum=0;
        recur(root,low,high);
        return sum;
    }
}