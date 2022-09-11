class Solution {
    public int maxProfit(int[] arr, int fee) {
        int n=arr.length;
        int[] dp=new int[n];
        dp[0]=0;
        int max=-arr[0];
        for(int i=1;i<n;i++)
        {
            dp[i]=dp[i-1];
            dp[i]=Math.max(dp[i],max+arr[i]-fee);
            max=Math.max(max,dp[i]-arr[i]);
        }
        return dp[n-1];
    }
}