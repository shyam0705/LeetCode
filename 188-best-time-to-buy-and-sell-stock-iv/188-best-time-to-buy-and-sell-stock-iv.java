class Solution {
    public int maxProfit(int k, int[] arr) {
        int n=arr.length;
        int[][] dp=new int[n+1][k+1];
        for(int i=0;i<=k;i++)
        {
            for(int j=0;j<=n;j++)
            {
                
                if(i==0 || j==0 || j==1)
                {
                    dp[j][i]=0;
                }
                else
                {
                    dp[j][i]=dp[j-1][i];
                    for(int l=1;l<=j;l++)
                        dp[j][i]=Math.max(dp[l-1][i-1]+(arr[j-1]-arr[l-1]),dp[j][i]);
                }
            }
        }
        return dp[n][k];
        
    }
}