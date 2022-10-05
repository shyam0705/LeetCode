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
    public TreeNode add(TreeNode root,int val,int d,int current)
    {
       
        if(root==null)
        {
            return null;
        }
        if(d==1)
        {
            TreeNode tmp=new TreeNode(val);
            tmp.left=root;
            return tmp;
        }
        if(current==(d-1))
        {
            TreeNode tmp1=new TreeNode(val);
            TreeNode tmp2=new TreeNode(val);
            tmp1.left=root.left;
            tmp2.right=root.right;
            root.left=tmp1;
            root.right=tmp2;
            return root;
        }
        root.left=add(root.left,val,d,current+1);
        root.right=add(root.right,val,d,current+1);
        return root;
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return add(root,val,depth,1);
    }
}