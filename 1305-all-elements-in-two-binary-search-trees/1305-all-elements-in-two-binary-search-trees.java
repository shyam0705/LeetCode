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
    public List<Integer> inorder(TreeNode root)
    {
        TreeNode current=root;
        Stack<TreeNode>s=new Stack<>();
        List<Integer>ans=new ArrayList<>();
        while(true)
        {
            if(current==null)
            {
                if(s.isEmpty())
                {
                    break;
                }
                else
                {
                    TreeNode tmp=s.pop();
                    ans.add(tmp.val);
                    if(tmp.right!=null)
                    {
                        current=tmp.right;
                    }
                }
            }
            else
            {
                s.add(current);
                current=current.left;
            }
        }
        return ans;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer>arr1=inorder(root1);
        List<Integer>arr2=inorder(root2);
        return merge(arr1,arr2);
    }
    public List<Integer> merge(List<Integer>arr1,List<Integer>arr2)
    {
        int n=arr1.size();
        int m=arr2.size();
        int i=0;
        int j=0;
        List<Integer>ans=new ArrayList<>();
        while(i<n && j<m)
        {
            if(arr1.get(i)<arr2.get(j))
            {
                ans.add(arr1.get(i));
                i++;
            }
            else
            {
                ans.add(arr2.get(j));
                j++;
            }
        }
        while(i<n)
        {
             ans.add(arr1.get(i));
             i++;
        }
        while(j<m)
        {
                ans.add(arr2.get(j));
                j++;
        }
        return ans;
        
    }
}