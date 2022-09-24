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
    List<List<Integer>>ans;
    public void recur(TreeNode root,int sum,List<Integer>current)
    {
        if(root==null)
        {
            return;
        }
        sum=sum-root.val;
        current.add(root.val);
        if(root.left==null && root.right==null && sum==0)
        {
                ans.add(new ArrayList<>(current));
        }
        else
        {
            recur(root.left,sum,current);
            recur(root.right,sum,current);
        }
        sum=sum+root.val;
        current.remove(current.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans=new ArrayList<>();
        recur(root,targetSum,new ArrayList<>());
        return ans;
    }
}