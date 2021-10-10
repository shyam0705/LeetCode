class Trie {

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode()
        {
            isEnd=false;
            children=new TrieNode[26];
        }
    }
    TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current=root;
        int n=word.length();
        for(int i=0;i<n;i++)
        {
            if(current.children[word.charAt(i)-'a']==null)
            {
                current.children[word.charAt(i)-'a']=new TrieNode();
            }
            current=current.children[word.charAt(i)-'a'];
            
        }
        current.isEnd=true;
    }
    
    public boolean search(String word) {
        TrieNode current=root;
        int n=word.length();
        for(int i=0;i<n;i++)
        {
            if(current.children[word.charAt(i)-'a']==null)
            {
                return false;
            }
            current=current.children[word.charAt(i)-'a'];  
        }
        return current.isEnd;
    }
    
    public boolean startsWith(String word) {
        TrieNode current=root;
        int n=word.length();
        for(int i=0;i<n;i++)
        {
            if(current.children[word.charAt(i)-'a']==null)
            {
                return false;
            }
            current=current.children[word.charAt(i)-'a'];  
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */