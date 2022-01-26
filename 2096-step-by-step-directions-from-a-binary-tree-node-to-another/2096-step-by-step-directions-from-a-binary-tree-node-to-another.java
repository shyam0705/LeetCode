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
    String ans;
    public void dfs(TreeNode root,int start,int dest,StringBuilder current1,StringBuilder current2)
    {
        if(root==null)
        {
            return;
        }
        if(root.val==start)
        {
            ans=current1.toString()+ans;
            return;
        }
        if(root.val==dest)
        {
            ans=ans+current2.toString();
            return;
        }
        current1.append('U');
        current2.append('L');
        dfs(root.left,start,dest,current1,current2);
        current2.deleteCharAt(current2.length()-1);
        current2.append('R');
        dfs(root.right,start,dest,current1,current2);
        current2.deleteCharAt(current2.length()-1);
        current1.deleteCharAt(current1.length()-1);
    }
    public TreeNode lca(TreeNode root,int start,int dest)
    {
        if(root==null)
        {
            return null;
        }
        if(root.val==start || root.val==dest)
        {
            return root;
        }
        TreeNode l=lca(root.left,start,dest);
        TreeNode r=lca(root.right,start,dest);
        if(l!=null && r!=null)
        {
            return root;
        }
        if(l==null)
        {
            return r;
        }
        return l;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca=lca(root,startValue,destValue);
        ans="";
        StringBuilder current1=new StringBuilder("U");
        StringBuilder current2=new StringBuilder("L");
        StringBuilder c1=new StringBuilder("U");
        StringBuilder c2=new StringBuilder("R");
        dfs(lca.left,startValue,destValue,current1,current2);
        dfs(lca.right,startValue,destValue,c1,c2);
        return ans;
    }
}