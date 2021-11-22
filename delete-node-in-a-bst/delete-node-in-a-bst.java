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
    public TreeNode recur(TreeNode root,int key)
    {
        if(root==null)
        {
            return null;
        }
        if(root.val==key)
        {
            if(root.right==null)
            {
                return root.left;
            }
            else
            {
                TreeNode tmp=root.left;
                TreeNode tmp1=root.right;
                TreeNode right=tmp1;
                while(tmp1.left!=null)
                {
                    tmp1=tmp1.left;
                }
                tmp1.left=tmp;
                return right;
            }
        }
        root.left=recur(root.left,key);
        root.right=recur(root.right,key);
        return root;
        
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        return recur(root,key);
    }
}