class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        int n=startWords.length;
        int m=targetWords.length;
        HashMap<Integer,Integer>hs1=new HashMap<>();
        for(int i=0;i<m;i++)
        {
            int tmp=calHash(targetWords[i]);
            hs1.put(tmp,hs1.getOrDefault(tmp,0)+1);
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            String s=startWords[i];
            int hash=calHash(s);
            for(int j=0;j<=26;j++)
            {
                if(!set(hash,j))
                {
                    int tmp=hash+(1<<j);
                    if(hs1.containsKey(tmp))
                    {
                        int c=hs1.get(tmp);
                        count=count+c;
                        hs1.remove(tmp);
                    }
                }
            }
        }
        return count;
    }
    public int calHash(String s)
    {
        int n=s.length();
        int val=0;
        for(int i=0;i<n;i++)
        {
            int tmp=s.charAt(i)-'a';
            val=val+(1<<tmp);
        }
        return val;
    }
    public boolean set(int hash,int i)
    {
       
        int tmp=(hash>>i)&1;
        return tmp==1;
    }
}