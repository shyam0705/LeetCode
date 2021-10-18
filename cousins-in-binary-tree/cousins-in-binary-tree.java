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
    public TreeNode find(TreeNode root, int x)
    {
        if(root==null)
        {
            return null;
        }
        if(root.left!=null)
        {
            if(root.left.val==x)
            {
               return root; 
            }
            TreeNode tmp=find(root.left,x);
            if(tmp!=null)
                return tmp;
        }
        if(root.right!=null)
        {
            if(root.right.val==x)
            {
                return root;
            }
            TreeNode tmp=find(root.right,x);
            if(tmp!=null)
                return tmp;
        }
        return null;
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode tmp1=find(root,x);
        TreeNode tmp2=find(root,y);     
        int depth1=depth(root,x);
        int depth2=depth(root,y);
        //System.out.println(depth1);
        //System.out.println(depth2);
        if(tmp1!=null && tmp2!=null && tmp1!=tmp2 && (depth1==depth2))
        {
            return true;
        }
        return false;
    }
    public int depth(TreeNode root,int x)
    {
         if (root == null)
            return -1;

        // Initialize distance as -1
        int dist = -1;

        // Check if x is current node=
        if ((root.val == x)||

            
            (dist = depth(root.left, x)) >= 0 ||

            (dist = depth(root.right, x)) >= 0)

            return dist + 1;

        return dist;
    }
}