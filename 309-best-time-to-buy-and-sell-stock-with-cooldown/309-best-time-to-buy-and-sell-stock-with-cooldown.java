class Solution {
    int n;
    int[] dp;
    public int recur(int i,int[] arr)
    {
       
        if(i>=n)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int ans=recur(i+1,arr);
        for(int j=i+1;j<n;j++)
        {
            if(arr[j]>arr[i])
            {
                int tmp=arr[j]-arr[i]+recur(j+2,arr);
                // System.out.println(tmp);
                ans=Math.max(ans,tmp);
            }
        }
        dp[i]=ans;
        return ans;
    }
    public int maxProfit(int[] prices) {
        n=prices.length;
        dp=new int[n];
        for(int i=0;i<n;i++)
        {
            dp[i]=-1;
        }
        return recur(0,prices);
    }
}