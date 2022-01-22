class Solution {
    int[] dp;
    public boolean canWin(int n)
    {
        if(n==0)
        {
            return false;
        }
        if(dp[n]!=0)
        {
            return dp[n]==1;
        }
        for(int i=1;i*i<=n;i++)
        {
            boolean ans=canWin(n-(i*i));
            if(!ans)
            {
                dp[n]=1;
                return true; 
            }
        }
        dp[n]=-1;
        return false;
    }
    public boolean winnerSquareGame(int n) {
        dp=new int[n+1];
        return canWin(n);
    }
}