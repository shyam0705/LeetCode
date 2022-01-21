class Solution{
    int n;
    int[][] dp;
    public int recur(int[] arr,int k,int index)
    {
        if(index>=n)
        {
            return -1;
        }
        if(k==1)
        {
            int sum=0;
            for(int i=index;i<n;i++)
            {
                sum=sum+arr[i];
            }
            return sum;
        }
        if(dp[index][k]!=-2)
        {
            return dp[index][k];
        }
        int sum=0;
        int ans=Integer.MAX_VALUE;
        for(int i=index;i<n;i++)
        {
            sum=sum+arr[i];
            int tmp=recur(arr,k-1,i+1);
            if(tmp!=-1)
            {
                ans=Math.min(ans,Math.max(tmp,sum));
            }
        }
        if(ans==Integer.MAX_VALUE)
        {
            dp[index][k]=-1;
            return -1;
        }
        dp[index][k]=ans;
        return ans;
    }
    public int splitArray(int[] nums, int m) {
        n=nums.length;
        dp=new int[n][m+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                dp[i][j]=-2;
            }
        }
        return recur(nums,m,0);
    }
}