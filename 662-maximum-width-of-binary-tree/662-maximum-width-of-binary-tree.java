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
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode>q=new LinkedList<>();
        q.add(root);
        int ans=1;
        root.val=0;
        while(!q.isEmpty())
        {
            int n=q.size();
            ans=Math.max(ans,q.peekLast().val-q.peekFirst().val+1);
            for(int i=0;i<n;i++)
            {
                TreeNode tmp=q.remove();
                if(tmp.left!=null)
                {
                    tmp.left.val=tmp.val*2;
                    q.add(tmp.left);
                }
                if(tmp.right!=null)
                {
                    tmp.right.val=tmp.val*2+1;
                    q.add(tmp.right);
                }
            }
        }
        return ans;
    }
}