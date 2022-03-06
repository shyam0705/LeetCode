class Solution {
    long mod=1000000007;
    long[][] dp;
    public long recur(int open,int close)
    {
        if(close==0 && open==0)
        {
            return 1;
        }
        if(dp[open][close]!=-1)
        {
            return dp[open][close];
        }
        long tmp1=0;
        long tmp2=0;
        if(open!=0)
        {
            tmp1=(open*recur(open-1,close+1))%mod;
        }
        if(close!=0)
        {
            tmp2=(close*recur(open,close-1))%mod;
        }
        long tmp=(tmp1+tmp2)%mod;
        dp[open][close]=tmp;
        return tmp;
        
    }
    public int countOrders(int n) {
        dp=new long[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                dp[i][j]=-1;
            }
        }
        return (int)recur(n,0);
    }
}