class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        long[][] dp=new long[n+1][target+1];
        long mod=1000000007;
        for(int i=0;i<=target;i++)
        {
            
            for(int j=0;j<=n;j++)
            {
                for(int l=1;l<=k;l++)
                {
                    if(j==0 && i==0)
                    {
                        dp[j][i]=1;
                    }
                    else if(j==0 || i==0)
                    {
                        dp[j][i]=0;
                    }
                    else
                    {
                        if(i-l>=0)
                        {
                            dp[j][i]=(dp[j][i]+dp[j-1][i-l])%mod;
                        }
                    }
                }
            }
        }
        return (int)dp[n][target];
    }
}