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
    
    public void add(HashMap<Integer,ArrayList<Integer>>mp,int u,int v)
    {
        if(mp.containsKey(u))
        {
                mp.get(u).add(v);
        }
        else
        {
                ArrayList<Integer>tmp=new ArrayList<>();
                tmp.add(v);
                mp.put(u,tmp);
        }
    }
    public void dfs(TreeNode root, HashMap<Integer,ArrayList<Integer>>mp)
    {
        if(root==null)
            return;
        if(root.left!=null)
        {
            int u=root.val;
            int v=root.left.val;
            add(mp,u,v);
            add(mp,v,u);
            dfs(root.left,mp);
        }
        if(root.right!=null)
        {
            int u=root.val;
            int v=root.right.val;
            add(mp,u,v);
            add(mp,v,u);
            dfs(root.right,mp);
        }
    }
    public int amountOfTime(TreeNode root, int start) {
        
        if(root==null || (root.left==null && root.right==null))
        {
            return 0;
        }
        
        HashMap<Integer,ArrayList<Integer>>mp=new HashMap<>();
        dfs(root,mp);
        Queue<Integer>q=new LinkedList<>();
        HashSet<Integer>visited=new HashSet<>();
        
        q.add(start);
        int count=-1;
        visited.add(start);
        while(!q.isEmpty())
        {
            int n=q.size();
            count++;
            for(int i=0;i<n;i++)
            {
                int tmp=q.remove();
                // System.out.println(tmp);
                for(Integer el:mp.get(tmp))
                {
                    if(!visited.contains(el))
                    {
                        visited.add(el);
                        q.add(el);
                    }
                }
            }
        }
        return count;
    }
}