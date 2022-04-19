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
    ArrayList<TreeNode>ans;
    public void inorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        ans.add(root);
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        ans=new ArrayList<>();
        inorder(root);
        TreeNode tmp1=null;
        TreeNode tmp2=null;
        int n=ans.size();
        for(int i=0;i<n-1;i++)
        {
            if(ans.get(i).val>ans.get(i+1).val)
            {
                tmp1=ans.get(i);
                break;
            }
        }
        for(int i=n-1;i>=1;i--)
        {
            if(ans.get(i).val<ans.get(i-1).val)
            {
                tmp2=ans.get(i);
                break;
            }
        }
        int tmp=tmp1.val;
        tmp1.val=tmp2.val;
        tmp2.val=tmp;
    }
}