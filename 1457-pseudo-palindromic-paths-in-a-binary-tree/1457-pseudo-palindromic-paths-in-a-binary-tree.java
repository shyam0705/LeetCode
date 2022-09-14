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
    int[] f;
    int count;
    public void recur(TreeNode root)
    {
        if(root==null)
            return;
        f[root.val]++;
        if(root.left==null && root.right==null && isValid())
        {
            //System.out.println(root.val);
            count++;
        }
        recur(root.left);
        recur(root.right);
        f[root.val]--;
    }
    public boolean isValid()
    {

        int check=0;
        for(int i=0;i<10;i++)
        {
            if(f[i]%2!=0)
            {
                check++;
            }
        }
        return check<=1;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        f=new int[10];
        count=0;
        recur(root);
        return count;
    }
}