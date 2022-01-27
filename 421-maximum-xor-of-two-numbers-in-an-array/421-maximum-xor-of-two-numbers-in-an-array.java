class Solution {
    public class TrieNode{
        TrieNode[] child;
        TrieNode(){
            child=new TrieNode[2];
            child[0]=null;
            child[1]=null;
        }
    }
    public class Trie{
        TrieNode root;
        Trie()
        {
            root=new TrieNode();
        }
        public void insert(int num)
        {
            TrieNode current=root;
            for(int i=31;i>=0;i--)
            {
                int bit=(num>>i)&1;
                if(current.child[bit]==null)
                {
                    current.child[bit]=new TrieNode();
                }
                current=current.child[bit];
            }
        }
        public int maxOfOne(int num)
        {
            TrieNode current=root;
            int ans=0;
            for(int i=31;i>=0;i--)
            {
                if(current==null)
                {
                    break;
                }
                int bit=(num>>i)&1;
                if(current.child[1-bit]!=null)
                {
                    ans=ans+(1<<i);
                    current=current.child[1-bit];
                }
                else
                {
                    current=current.child[bit];
                }
                
            }
            return ans;
            
        }
        
    }
    public int findMaximumXOR(int[] nums) {
        int n=nums.length;
        Trie trie=new Trie();
        for(int i=0;i<n;i++)
        {
            trie.insert(nums[i]);
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,trie.maxOfOne(nums[i]));
        }
        return ans;
    }
}