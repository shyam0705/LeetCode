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
    public List<Integer> optimal(TreeNode root1,TreeNode root2)
    {
        TreeNode current1=root1;
        TreeNode current2=root2;
        Stack<TreeNode>s1=new Stack<>();
        Stack<TreeNode>s2=new Stack<>();
        List<Integer>ans=new ArrayList<>();
        while(true)
        {
            if(current1==null && current2==null)
            {
                if(s1.isEmpty() && s2.isEmpty())
                {
                    break;
                }
                else if(s1.isEmpty())
                {
                    TreeNode tmp=s2.pop();
                    ans.add(tmp.val);
                    if(tmp.right!=null)
                    {
                        current2=tmp.right;
                    }
                }
                else if(s2.isEmpty())
                {
                    TreeNode tmp=s1.pop();
                    ans.add(tmp.val);
                    if(tmp.right!=null)
                    {
                        current1=tmp.right;
                    }
                }
                else
                {
                    TreeNode tmp1=s1.peek();
                    TreeNode tmp2=s2.peek();
                    if(tmp1.val<tmp2.val)
                    {
                        TreeNode tmp=s1.pop();
                        ans.add(tmp.val);
                        if(tmp.right!=null)
                        {
                            current1=tmp.right;
                        } 
                    }
                    else
                    {
                        TreeNode tmp=s2.pop();
                        ans.add(tmp.val);
                        if(tmp.right!=null)
                        {
                            current2=tmp.right;
                        }
                    }
                }
            }
            else if(current1==null)
            {
                s2.add(current2);
                current2=current2.left;
            }
            else if(current2==null)
            {
               s1.add(current1);
                current1=current1.left;
            }
            else
            {
                s1.add(current1);
                s2.add(current2);
                current1=current1.left;
                current2=current2.left;
            }
        }
        return ans;
    }
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // List<Integer>arr1=inorder(root1);
        // List<Integer>arr2=inorder(root2);
        // return merge(arr1,arr2);
        return optimal(root1,root2);
    }
    
}