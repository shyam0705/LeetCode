class Solution {
    public int recur(int[] nums,int n)
    {
        if(n==1)
        {
            return nums[0];
        }
        for(int i=0;i<n-1;i++)
        {
            nums[i]=(nums[i]+nums[i+1])%10;
        }
        return recur(nums,n-1);
    }
    public int triangularSum(int[] nums) {
        return recur(nums,nums.length);
    }
}