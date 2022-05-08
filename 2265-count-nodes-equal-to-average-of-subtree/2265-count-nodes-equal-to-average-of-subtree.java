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
    class Pair{
        int sum,n;
        Pair(int sum,int n)
        {
            this.sum=sum;
            this.n=n;
        }
    }
    int count;
    public Pair recur(TreeNode root)
    {
        if(root==null)
        {
            return new Pair(0,0);
        }
        if(root.left==null && root.right==null)
        {
            count++;
            return new Pair(root.val,1);
        }
        Pair p1=recur(root.left);
        Pair p2=recur(root.right);
        int avg=(p1.sum+p2.sum+root.val)/(p1.n+p2.n+1);
        if(avg==root.val)
        {
            count++;
        }
        return new Pair(p1.sum+p2.sum+root.val,p1.n+p2.n+1);
    }
    public int averageOfSubtree(TreeNode root) {
        count=0;
        recur(root);
        return count;
    }
}