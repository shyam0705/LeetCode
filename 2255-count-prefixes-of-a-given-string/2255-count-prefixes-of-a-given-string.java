class Solution {
    public int countPrefixes(String[] words, String s) {
        HashMap<String,Integer>mp=new HashMap<>();
        int n=words.length;
        for(int i=0;i<n;i++)
        {
            mp.put(words[i],mp.getOrDefault(words[i],0)+1);
        }
        int m=s.length();
        int count=0;
        for(int i=0;i<m;i++)
        {
            String tmp=s.substring(0,i+1);
            count=count+mp.getOrDefault(tmp,0);
        }
        return count;
    }
}