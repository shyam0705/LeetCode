class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=1;
        int last=nums[0];
        int max_el=nums[0];
        for(int i=1;i<n;i++)
        {
            if((last&nums[i])==nums[i])
            {
                dp[i]=dp[i-1]+1;
            }
            else
            {
                dp[i]=1;
            }
            max_el=Math.max(max_el,nums[i]);
            last=nums[i];
        }
        int max=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==max_el)
            {
                max=Math.max(max,dp[i]);
            }
        }
        return max;
    }
}