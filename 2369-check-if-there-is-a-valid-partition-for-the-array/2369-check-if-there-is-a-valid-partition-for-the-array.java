class Solution {
    int[] dp;
    public boolean recur(int[] nums,int i,int n)
    {
        
        if(i>=n)
            return true;
        else if(i==n-1)
            return false;
        else if(i==n-2)
        {
            if(nums[i]==nums[i+1])
            {
                return true;
            }
            return false;
        }
        if(dp[i]!=-1)
        {
            return dp[i]==1;
        }
        else
        {
            if(nums[i]==nums[i+1])
            {
                if(recur(nums,i+2,n))
                {
                    dp[i]=1;
                    return true;
                }
                if(nums[i+1]==nums[i+2])
                {
                    if(recur(nums,i+3,n))
                    {
                        dp[i]=1;
                        return true;
                    }
                }
            }
            if(nums[i+1]==nums[i]+1 && nums[i+2]==nums[i+1]+1)
            {
                if(recur(nums,i+3,n))
                {
                    dp[i]=1;
                    return true;
                }
            }
            dp[i]=0;
            return false;
        }
        
    }
    public boolean validPartition(int[] nums) {
        int n=nums.length;
        dp=new int[n];
        for(int i=0;i<n;i++)
        {
            dp[i]=-1;
        }
        return recur(nums,0,n);
    }
}