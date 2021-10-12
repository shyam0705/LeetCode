class Solution {
    int[] dp;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
         if (((1 + maxChoosableInteger) / 2 * maxChoosableInteger) < desiredTotal) {
            return false;
        }
        dp=new int[(1<<maxChoosableInteger)+1];
        for(int i=0;i<dp.length;i++)
        {
            dp[i]=-1;
        }
        if(desiredTotal<=maxChoosableInteger)
        {
            return true;
        }
        return recur(0,maxChoosableInteger,desiredTotal);
    }
    public boolean recur(int state,int n,int sum)
    {
        if(sum<=0)
        {
            return false;
        }
        if(dp[state]!=-1)
        {
            return dp[state]==1?true:false;
        }
        for(int i=1;i<=n;i++)
        {
            int tmp=1<<(i-1);
            if((state & tmp)==0)
            {
                if(!recur(state | tmp,n,sum-i))
                {
                    dp[state]=1;
                    return true;
                }
            }
        }
        dp[state]=0;
        return false;
    }
}