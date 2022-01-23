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
    public TreeNode recur(int[] arr,int l,int r)
    {
        if(l>r)
        {
            return null;
        }
        if(l==r)
        {
            return new TreeNode(arr[l]);
        }
        int index=l;
        int max=arr[l];
        for(int i=l+1;i<=r;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
                index=i;
            }
        }
        TreeNode root=new TreeNode(max);
        root.left=recur(arr,l,index-1);
        root.right=recur(arr,index+1,r);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n=nums.length;
        return recur(nums,0,n-1);
    }
}