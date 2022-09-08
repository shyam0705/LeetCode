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
   
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        TreeNode current=root;
        while(current!=null)
        {
            if(current.left==null)
            {
                ans.add(current.val);
                current=current.right;
            }
            else
            {
               TreeNode tmp=current.left;
                while(tmp.right!=null && tmp.right!=current)
                {
                    tmp=tmp.right;
                }
                if(tmp.right==null)
                {
                    tmp.right=current;
                    current=current.left;
                }
                else
                {
                    tmp.right=null;
                    ans.add(current.val);
                    current=current.right;
                }
            }
        }
        return ans;
        
    }
}