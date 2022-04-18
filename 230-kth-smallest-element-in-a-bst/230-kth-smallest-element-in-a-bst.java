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
    public int recur(TreeNode root,int k)
    {
       if(root==null)
       {
           return 0;
       }
      int tmp=recur(root.left,k);
      if(tmp==k-1)
      {
          ans=root.val;
      }
      return 1+tmp+recur(root.right,k-tmp-1);
    }
    public int kthSmallest(TreeNode root, int k) {
        ans=-1;
        recur(root,k);
        return ans;
    }
}