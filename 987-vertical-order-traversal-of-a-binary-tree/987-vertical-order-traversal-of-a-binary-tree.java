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


class Node{
    int r,c,v;
    TreeNode left;
    TreeNode right;
    Node(int r,int c,int v,TreeNode left,TreeNode right)
    {
        this.r=r;
        this.c=c;
        this.v=v;
        this.left=left;
        this.right=right;
        
    }
    
}

class Solution {
    
 
    TreeMap<Integer,ArrayList<Node>>mp;
    public  void recur(Node root)
    {
        if(root==null)
            return;
        int c=root.c;
        if(mp.containsKey(c))
        {
            mp.get(c).add(root);
        }
        else
        {
            ArrayList<Node>tmp=new ArrayList<>();
            tmp.add(root);
            mp.put(c,tmp);
        }
        if(root.left!=null)
        {
             recur(new Node(root.r+1,
                            root.c-1,
                            root.left.val,
                            root.left.left,
                            root.left.right));
        }
           
        if(root.right!=null)
        {
            recur(new Node(root.r+1,
                           root.c+1,
                           root.right.val,
                           root.right.left,
                           root.right.right));
        }
           
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        mp=new TreeMap<>();
        recur(new Node(0,0,root.val,root.left,root.right));
        List<List<Integer>>ans=new ArrayList<>();
        mp.forEach((k,v)->{
            Collections.sort(v,(a,b)->{
                if(a.r==b.r)
                {
                    return a.v-b.v;
                }
                return a.r-b.r;
            });
            List<Integer>tmp=new ArrayList<>();
            for(Node n:v)
            {
                tmp.add(n.v);
            }
            ans.add(tmp);
        });
        return ans;
    }
}