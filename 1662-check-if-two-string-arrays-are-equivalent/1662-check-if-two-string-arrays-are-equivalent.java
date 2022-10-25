class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();
        int n=word1.length;
        int m=word2.length;
        for(int i=0;i<n;i++)
        {
            s1.append(word1[i]);
        }
        for(int i=0;i<m;i++)
        {
            s2.append(word2[i]);
        }
        
        if(s1.toString().equals(s2.toString()))
        {
            return true;
        }
        return false;
    }
}