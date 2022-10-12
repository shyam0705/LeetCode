class Solution {
    public int largestPerimeter(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int j=n-3;
        while(j>=0)
        {
            if(nums[j]+nums[j+1]>nums[j+2])
            {
                return nums[j]+nums[j+1]+nums[j+2];
            }
            j--;
        }
        return 0;
    }
}