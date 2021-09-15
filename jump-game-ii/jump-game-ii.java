class Solution {
    int[] dp;
    public int recur(int[] nums,int i,int n)
    {
        if(i==n-1)
        {
            return 0;
        }
        if(i+nums[i]>=(n-1))
        {
            return 1;
        }
        if(dp[i]!=-2)
        {
            return dp[i];
        }
        int ans=Integer.MAX_VALUE;
        for(int j=1;j<=nums[i];j++)
        {
            int tmp=recur(nums,i+j,n);
            if(tmp!=-1)
            {
                ans=Math.min(tmp,ans);
            }
        }
        if(ans==Integer.MAX_VALUE)
        {
            dp[i]=-1;
            return -1;
        }
        dp[i]=1+ans;
        return 1+ans;
    }
    public int jump(int[] nums) {
        dp=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            dp[i]=-2;
        }
        return recur(nums,0,nums.length);
    }
}