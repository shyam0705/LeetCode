class Solution {
    boolean[] perfect;
    int[] dp;
    // public boolean perfect(int n)
    // {
    //     if(n==1)
    //     {
    //         return true;
    //     }
    //     for(int i=1;i*i<=n;i++)
    //     {
    //         if((i*i)==n)
    //         {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    public int recur(int n)
    {
        if(perfect[n])
        {
            return 1;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        int ans=n;
        for(int i=1;i<=n;i++)
        {
            if(perfect[i])
            {
                int tmp=1+recur(n-i);
                ans=Math.min(ans,tmp);
            }
        }
        dp[n]=ans;
        return ans;
    }
    public int numSquares(int n) {
        dp=new int[10001];
        for(int i=0;i<10001;i++)
        {
            dp[i]=-1;
        }
        perfect=new boolean[10001];
        for(int i=1;i<=100;i++)
        {
            perfect[i*i]=true;
        }
        return recur(n);
    }
}