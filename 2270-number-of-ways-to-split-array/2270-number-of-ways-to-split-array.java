class Solution {
    public int waysToSplitArray(int[] nums) {
       long sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            sum=sum+(long)nums[i];
        }
        int count=0;
        long current_sum=0;
        for(int i=0;i<n-1;i++)
        {
            current_sum=current_sum+(long)nums[i];
            sum=sum-nums[i];
            if(current_sum>=sum)
            {
                count++;
            }
        }
        return count;
    }
}