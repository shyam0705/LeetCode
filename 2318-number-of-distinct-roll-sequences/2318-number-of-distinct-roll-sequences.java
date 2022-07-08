class Solution {
    long[][][] dp;
    long mod;
    public boolean isValid(int n,int last,int second_last)
    {
        if(n==last || n==second_last)
            return false;
        if(gcd(n,last)!=1)
            return false;
        return true;
    }
    public int gcd(int a,int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    public long recur(int n,int last,int second_last)
    {
        if(n==0)
            return 1;
        
        long count=0;
        if(dp[n][last][second_last]!=-1)
        {
            return dp[n][last][second_last];
        }
        for(int i=1;i<=6;i++)
        {
            if(isValid(i,last,second_last))
            {
                count=(count+recur(n-1,i,last))%mod;
            }
        }
        dp[n][last][second_last]=count;
        return count;
    }
    public int distinctSequences(int n) {
        
        long count=0;
        dp=new long[n+1][7][7];
        mod=1000000007;
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=6;j++)
            {
                for(int k=0;k<=6;k++)
                {
                    dp[i][j][k]=-1;
                }
            }
        }
        for(int i=1;i<=6;i++)
        {
            count=(count+recur(n-1,i,0))%mod;
        }
       return (int)count;
    }
}