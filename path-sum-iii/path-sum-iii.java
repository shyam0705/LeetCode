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
        int ans=0;
        if(root.val==sum)
        {
            ans++;
        }
        ans+=recur(root.left,sum-root.val);
        ans+=recur(root.right,sum-root.val);
        return ans;
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
        {
            return 0;
        }
        return pathSum(root.left,targetSum)+pathSum(root.right,targetSum)+recur(root,targetSum);
    }
}