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
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode>s=new Stack<>();
        while(root!=null)
        {
            s.push(root);
            root=root.left;
        }
        while(!s.isEmpty())
        {
            TreeNode tmp=s.pop();
            ans.add(tmp.val);
            tmp=tmp.right;
            while(tmp!=null)
            {
                s.push(tmp);
                tmp=tmp.left;
            }
        }
        return ans;
        
    }
}