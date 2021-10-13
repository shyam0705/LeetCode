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
    int index;
    int n;
    public TreeNode recur(int[] preorder,int left,int right)
    {
        if(index>=n)
        {
            //System.out.println("check");
            return null;
        }
        if(preorder[index]>left && preorder[index]<right)
        {
            TreeNode root=new TreeNode(preorder[index]);
            index++;
            root.left=recur(preorder,left,root.val);
            root.right=recur(preorder,root.val,right);
            return root;
        }
         //System.out.println("check1");
        return null;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        n=preorder.length;
        index=0;
        return  recur(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}