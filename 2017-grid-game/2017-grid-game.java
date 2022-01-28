class Solution {
    public long gridGame(int[][] grid) {
        int n=grid[0].length;
        long[][] dp=new long[2][n+2];
        for(int i=1;i<=n;i++)
        {
            dp[0][i]=dp[0][i-1]+(long)grid[0][i-1];
            dp[1][i]=dp[1][i-1]+(long)grid[1][i-1];
        }
        long ans=Long.MAX_VALUE;
        for(int i=1;i<=n;i++)
        {
           
            ans=Math.min(ans,Math.max(dp[1][i-1],dp[0][n]-dp[0][i]));
        }
        return ans;
    }
}