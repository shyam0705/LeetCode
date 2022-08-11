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
    public class Node{
        boolean ans;
        int min;
        int max;
        Node(boolean ans,int min,int max)
        {
            this.ans=ans;
            this.min=min;
            this.max=max;
        }
    }
    public Node isValid(TreeNode root)
    {
        
        if(root.left==null && root.right==null)
        {
            return new Node(true,root.val,root.val);
        }
        if(root.left==null)
        {
            
            Node right=isValid(root.right);
            if(right.ans && root.val<right.min)
            {
                return new Node(true,root.val,right.max);
            }
            return new Node(false,root.val,right.max);
        }
        else if(root.right==null)
        {
            Node left=isValid(root.left);
            if(left.ans && root.val>left.max)
            {
                return new Node(true,left.min,root.val);
            }
            return new Node(false,left.min,root.val);
        }
        else
        {
            Node left=isValid(root.left);
            Node right=isValid(root.right);
            if(left.ans && root.val>left.max && right.ans && root.val<right.min)
            {
                return new Node(true,left.min,right.max);
            }
            return new Node(false,left.min,right.max);
        }
      
    }
    public boolean isValidBST(TreeNode root) {
        return isValid(root).ans;
    }
}