class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int max_end=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++)
        {
            max_end=Math.max(max_end+nums[i],nums[i]);
            max=Math.max(max_end,max);
        }
        return max;
    }
}