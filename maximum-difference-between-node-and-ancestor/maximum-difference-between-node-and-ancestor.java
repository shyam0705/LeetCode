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
    public int[] recur(TreeNode root)
    {
        
        int max=root.val;
        int min=root.val;
        if(root.left!=null)
        {
            int[] arr=recur(root.left);
            ans=Math.max(ans,Math.abs(arr[0]-root.val));
            ans=Math.max(ans,Math.abs(arr[1]-root.val));
            min=Math.min(min,arr[0]);
            max=Math.max(max,arr[1]);
        }
        if(root.right!=null)
        {
            int[] arr=recur(root.right);
            ans=Math.max(ans,Math.abs(arr[0]-root.val));
            ans=Math.max(ans,Math.abs(arr[1]-root.val));
            min=Math.min(min,arr[0]);
            max=Math.max(max,arr[1]);
        }
        int[] arr=new int[2];
        arr[0]=min;
        arr[1]=max;
        return arr;
        
    }
    public int maxAncestorDiff(TreeNode root) {
        ans=0;
        recur(root);
        return ans;
    }
}