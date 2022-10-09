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
    ArrayList<Integer>ans;
    public void inorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }
    public boolean findTarget(TreeNode root, int k) {
        ans=new ArrayList<>();
        inorder(root);
        int i=0;
        int j=ans.size()-1;
        while(i<j)
        {
            int x=ans.get(i);
            int y=ans.get(j);
            if(x+y==k)
            {
                return true;
            }
            if((x+y)>k)
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        return false;
    }
}