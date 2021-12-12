class Solution {
    public boolean subsetSum(int[] nums,int sum)
    {
        int n=nums.length;
        boolean[][] dp=new boolean[n][sum+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                
                if(j==0)
                {
                    dp[i][j]=true;
                }
                else if(i==0)
                {
                    dp[i][j]=false;
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                    if(nums[i]<=j)
                    {
                        dp[i][j]=dp[i][j] | dp[i-1][j-nums[i]];
                    }
                }
            }
        }
        return dp[n-1][sum];
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            sum=sum+nums[i];
        }
        if(sum%2!=0)
        {
            return false;
        }
        else
        {
            return subsetSum(nums,sum/2);
        }
    }
}