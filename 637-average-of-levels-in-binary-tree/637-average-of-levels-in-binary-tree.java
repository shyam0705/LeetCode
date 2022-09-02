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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        List<Double>ans=new ArrayList<>();
        while(!q.isEmpty())
        {
            int n=q.size();
            double sum=0;
            for(int i=0;i<n;i++)
            {
                TreeNode tmp=q.remove();
                sum=sum+tmp.val;
                if(tmp.left!=null)
                {
                    q.add(tmp.left);
                }
                if(tmp.right!=null)
                    q.add(tmp.right);
            }
            double avg=sum/(double)n;
            ans.add(avg);
        }
        return ans;
    }
}