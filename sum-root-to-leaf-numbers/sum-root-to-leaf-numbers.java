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
    public void recur(TreeNode root,String current)
    {
        if(root==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        {
            current=current+Integer.toString(root.val);
            sum=sum+Integer.parseInt(current);
            return;
        }
        recur(root.left,current+Integer.toString(root.val));
        recur(root.right,current+Integer.toString(root.val));
    }
    public int sumNumbers(TreeNode root) {
        sum=0;
        recur(root,"");
        return sum;
    }
}