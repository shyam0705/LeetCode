class Solution {
    public boolean checkSub(String s1,String s2)
    {
        int n=s1.length();
        int m=s2.length();
        if(n>m)
        {
            return false;
        }
        int i=0;
        int j=0;
        while(i<n && j<m)
        {
            if(s1.charAt(i)==s2.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                j++;
            }
        }
        if(i==n)
            return true;
        return false;
    }
    class TrieNode{
        TrieNode[] childrens;
        int isEnd;
        TrieNode()
        {
            isEnd=0;
            childrens=new TrieNode[26];
        }
    }
    class Trie{
        TrieNode root;
        Trie()
        {
            root=new TrieNode();
        }
        public void insert(String s)
        {
            int n=s.length();
            TrieNode current=root;
            for(int i=0;i<n;i++)
            {
                if(current.childrens[s.charAt(i)-'a']==null)
                {
                    current.childrens[s.charAt(i)-'a']=new TrieNode();
                }
                current=current.childrens[s.charAt(i)-'a'];
            }
            current.isEnd++;
        }
        public int countSubstring(TrieNode node,String current,String s)
        {
            int count=0;
            if(node.isEnd>0 && checkSub(current,s))
            {
                count=count+node.isEnd;
            }
            for(int i=0;i<26;i++)
            {
                if(node.childrens[i]!=null)
                {
                    count=count+countSubstring(node.childrens[i],current+(char)('a'+i),s);
                }
            }
            return count;
            
        }
    }
    public int numMatchingSubseq(String s, String[] words) {
        int n=words.length;
        Trie t=new Trie();
        for(int i=0;i<n;i++)
        {
            t.insert(words[i]);
        }
        return t.countSubstring(t.root,"",s);
    }
}