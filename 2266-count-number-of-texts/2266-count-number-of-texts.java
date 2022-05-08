class Solution {
    HashSet<String>hs;
    int n;
    long[] dp;
    long m=1000000007;
    public long recur(String s,int i)
    {
        if(i>=n)
        {
            return 1;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        int j=i;
        String tmp="";
        long count=0;
        while(j<n)
        {
            tmp=tmp+s.charAt(j);
            if(!hs.contains(tmp))
            {
                break;
            }
            else
            {
                count=(count+recur(s,j+1))%m;
            }
            j++;
        }
        dp[i]=count;
        return count;
    }
    public int countTexts(String pressedKeys) {
        hs=new HashSet<>();
        n=pressedKeys.length();
        for(int i=2;i<=9;i++)
        {
            if(i==7 || i==9)
            {
                String tmp="";
                for(int j=0;j<4;j++)
                {
                    tmp=tmp+(char)(i+'0');
                    hs.add(tmp);
                }
            }
            else
            {
                String tmp="";
                for(int j=0;j<3;j++)
                {
                    tmp=tmp+(char)(i+'0');
                    hs.add(tmp);
                }
            }
        }
        dp=new long[n];
        for(int i=0;i<n;i++)
        {
            dp[i]=-1;
        }
        return (int)recur(pressedKeys,0);
        
    }
}