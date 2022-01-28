class WordDictionary {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode()
        {
            children=new TrieNode[26];
            isEnd=false;
        }
    }
    class Trie{
        TrieNode root;
        Trie(){
            root=new TrieNode();
        }
        public void add(String s)
        {
            TrieNode current=root;
            for(int i=0;i<s.length();i++)
            {
                if(current.children[s.charAt(i)-'a']==null)
                {
                        current.children[s.charAt(i)-'a']=new TrieNode();    
                }
                current=current.children[s.charAt(i)-'a'];
            }
            current.isEnd=true;
        }
        public boolean search(TrieNode root1,int i,String s) 
        {
            int n=s.length();
            TrieNode current=root1;
            for(int j=i;j<n;j++)
            {
                if(s.charAt(j)=='.')
                {
                    for(int k=0;k<26;k++)
                    {
                        if(current.children[k]!=null &&                                                 search(current.children[k],j+1,s))
                        {
                            return true;
                        }
                    }
                    return false;
                }
                else
                {
                    if(current.children[s.charAt(j)-'a']!=null)
                    {
                        current=current.children[s.charAt(j)-'a'];
                    }
                    else
                    {
                        return false;
                    }
                }
            }
            return current.isEnd;
        }
    }
        Trie t;
    public WordDictionary() {
        t=new Trie();
    }
    
    public void addWord(String word) {
        t.add(word);
    }
    
    public boolean search(String word) {
        return t.search(t.root,0,word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */