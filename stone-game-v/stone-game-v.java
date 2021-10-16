class Solution {
    int[] right;
    int[][] dp;
    public int recur(int[] arr,int l,int r)
    {
        if(l==r)
        {
            return 0;
        }
        if(dp[l][r]!=-1)
        {
            return dp[l][r];
        }
        int sum=0;
        int ans=0;
        for(int i=l;i<r;i++)
        {
            sum=sum+arr[i];
            int sum2=right[i+1]-right[r+1];
            if(sum>sum2)
            {
                ans=Math.max(ans,recur(arr,i+1,r)+sum2);
            }
            else if(sum<sum2)
            {
                 ans=Math.max(ans,recur(arr,l,i)+sum);
            }
            else
            {
                 ans=Math.max(ans,Math.max(recur(arr,i+1,r)+sum2,recur(arr,l,i)+sum));
            }
        }
        dp[l][r]=ans;
        return ans;
    }
    public int stoneGameV(int[] arr) {
        int n=arr.length;
        dp=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
        right=new int[n+1];
        for(int i=n-1;i>=0;i--)
        {
            right[i]=right[i+1]+arr[i];
        }
        return recur(arr,0,n-1);
    }
}