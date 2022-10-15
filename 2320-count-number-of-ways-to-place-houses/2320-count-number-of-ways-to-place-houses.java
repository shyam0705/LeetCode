class Solution {
    
    long[] dp;
    long mod=1000000007;
    public long recur(int n,int current)
    {
        if(current>=n)
        {
            return 1;
        }
        
        if(dp[current]!=-1)
            return dp[current];
        long tmp=0;
        for(int i=current;i<=n;i++)
        {
            tmp=(tmp+recur(n,i+2))%mod;
        }
        
        dp[current]=tmp;
        return tmp;
    }
    public int countHousePlacements(int n) {
        dp=new long[n+1];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<=n;i++)
        {
            dp[i]=(dp[i-1]+dp[i-2])%mod;
        }
        long tmp1=dp[n];
        long ans=(tmp1*tmp1)%mod;
        return (int)ans;
    }
}