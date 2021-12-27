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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        Stack<TreeNode>s=new Stack<>();
        TreeNode current=root;
        while(true)
        {
            if(current!=null)
            {
                s.push(current);
                current=current.left;
            }
            else
            {
                if(s.isEmpty())
                {
                    break;
                }
                else
                {
                    TreeNode tmp=s.peek();
                    if(tmp.right==null)
                    {
                        ans.add(tmp.val);
                        s.pop();
                    }
                    else
                    {
                        current=tmp.right;
                        tmp.right=null;
                    }
                }
            }
        }
        return ans;
        
    }
}