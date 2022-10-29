class Solution {
    int n;
    
    int[][] dp;
    public int recur(int[] nums,int index,int k)
    {
        if(index==n)
        {
            return 0;
        }
        if(dp[index][k]!=-1)
        {
            return dp[index][k];
        }
        if(k==0)
        {
            int max=0;
            int sum=0;
            for(int i=index;i<n;i++)
            {
                sum=sum+nums[i];
                max=Math.max(max,nums[i]);
            }
            int count=n-index;
            return max*count-sum;
        }
        
        int sum=0;
        int max=0;
        int ans=Integer.MAX_VALUE;
        for(int i=index;i<n;i++)
        {
            sum=sum+nums[i];
            max=Math.max(max,nums[i]);
            
            int count=(i-index+1);
            int tmp=((count*max)-sum)+recur(nums,i+1,k-1);
            ans=Math.min(ans,tmp);
        }
        
        dp[index][k]=ans;
        return ans;
    }
    public int minSpaceWastedKResizing(int[] nums, int k) {
        n=nums.length;
        dp=new int[n][k+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=k;j++)
            {
                dp[i][j]=-1;
            }
        }
         return recur(nums,0,k);
        
    }
}