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
    List<TreeNode>ans;
    HashMap<String,Integer>mp;
    public String recur(TreeNode root)
    {
        if(root==null)
        {
            return "";
        }
        String tmp="("+recur(root.left)+root.val+recur(root.right)+")";
        if(mp.containsKey(tmp) && mp.get(tmp)==1)
        {
           ans.add(root); 
        }
        mp.put(tmp,mp.getOrDefault(tmp,0)+1);
        return tmp;
        
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        mp=new HashMap<>();
        ans=new ArrayList<>();
        recur(root);
        return ans;
    }
}