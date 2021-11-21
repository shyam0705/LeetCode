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
    public static int index;
    public TreeNode recur(int[] inorder,int[] postorder,int l,int r)
    {
        if(l>r || index<0)
        {
            return null;
        }
        int el=postorder[index];
        TreeNode root=new TreeNode(el);
        index--;
        for(int i=l;i<=r;i++)
        {
            if(inorder[i]==el)
            {
                root.right=recur(inorder,postorder,i+1,r);
                root.left=recur(inorder,postorder,l,i-1);
                break;
            }
        }
        return root;
        
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        index=n-1;
        return recur(inorder,postorder,0,n-1);
    }
}