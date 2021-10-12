class Solution {
    int[][] dp;
    public int recur(int l,int r)
    {
        if(l>r)
        {
            return 0;
        }
        if(l==r)
        {
            return 0;
        }
        if(dp[l][r]!=-1)
        {
            return dp[l][r];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=l;i<=r;i++)
        {
            int tmp=i+Math.max(recur(l,i-1),recur(i+1,r));
            ans=Math.min(ans,tmp);
        }
        dp[l][r]=ans;
        return ans;
    }
    public int getMoneyAmount(int n) {
        dp=new int[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                dp[i][j]=-1;
            }
        }
       return recur(1,n);
    }
}