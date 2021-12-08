class StreamChecker {
    class TrieNode{
        TrieNode[] children=new TrieNode[26];
        boolean isEnd=false;
    }
    class Trie{
        public TrieNode root;
        public Trie()
        {   
            root=new TrieNode();
        }
        public void insert(String s)
        {
            int n=s.length();
            TrieNode current=root;
            for(int i=0;i<n;i++)
            {
                if(current.children[s.charAt(i)-'a']==null)
                {
                    current.children[s.charAt(i)-'a']=new TrieNode();
                }
                current=current.children[s.charAt(i)-'a'];
            }
            current.isEnd=true;
        }
        public boolean search(String s)
        {
            int n=s.length();
            TrieNode current=root;
            for(int i=n-1;i>=0;i--)
            {
                if(current.children[s.charAt(i)-'a']==null)
                {
                    return false;
                }
                else
                {
                    if(current.children[s.charAt(i)-'a'].isEnd)
                    {
                        return true;
                    }
                    current=current.children[s.charAt(i)-'a'];
                }
            }
            return false;
        }
    }
    Trie trie;
    public StreamChecker(String[] words) {
        trie=new Trie();
        for(int i=0;i<words.length;i++)
        {
            trie.insert(reverse(words[i]));
        }
        
    }
    String s="";
    public boolean query(char letter) {
        s+=letter;
        return trie.search(s);
    }
    public String reverse(String s)
    {
        int l=0;
        int r=s.length()-1;
        String s_new="";
        for(int i=r;i>=0;i--)
        {
            s_new=s_new+s.charAt(i);
        }
        return s_new;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */