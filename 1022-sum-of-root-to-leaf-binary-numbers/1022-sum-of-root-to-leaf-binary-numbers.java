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
    int ans;
    public int recur(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        if(root.left==null && root.right==null)
        {
            if(root.val==1)
            {
                 ans++;
            }
           
            return 1;
        }
        int tmp1=recur(root.left);
        int tmp2=recur(root.right);
        int tmp=(tmp1+tmp2)*root.val*2;
        ans=ans+tmp;
        return (tmp1+tmp2)*2;
    }
    public int sumRootToLeaf(TreeNode root) {
        ans=0;
        recur(root);
        return ans;
    }
}