class Solution {
    public int maxProfit(int[] price) {
        int n=price.length;
        int[] dp=new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++)
        {
            dp[i]=dp[i-1];
            for(int j=0;j<i;j++)
            {
                if(price[j]<price[i])
                {
                    int tmp=price[i]-price[j];
                    if(j>=2)
                    {
                        tmp=tmp+dp[j-2];
                    }
                    dp[i]=Math.max(dp[i],tmp);
                }
            }
        }
        return dp[n-1];
    }
}