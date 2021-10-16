class Solution {
    int n;
    int[] sum_arr;
    int[][] dp;
    public int recur(int[] arr,int i,int m)
    {
        if(i>=n)
        {
            return 0;
        }
        if((n-i)<=2*m)
        {
            return sum_arr[i];
        }
        if(dp[i][m]!=-1)
        {
            return dp[i][m];
        }
        int sum=0;
        int ans=Integer.MIN_VALUE;
        for(int j=i;j<i+2*m && j<n;j++)
        {
            sum=sum+arr[j];
            int tmp=sum+sum_arr[j+1]-recur(arr,j+1,Math.min(Math.max(m,(j-i+1)),n));
            ans=Math.max(ans,tmp);
        }
        dp[i][m]=ans;
        return ans;
        
    }
    public int stoneGameII(int[] piles) {
        n=piles.length;
        dp=new int[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                dp[i][j]=-1;
            }
        }
        sum_arr=new int[n+1];
        for(int i=n-1;i>=0;i--)
        {
            sum_arr[i]=sum_arr[i+1]+piles[i];
        }
        return recur(piles,0,1);
    }
}