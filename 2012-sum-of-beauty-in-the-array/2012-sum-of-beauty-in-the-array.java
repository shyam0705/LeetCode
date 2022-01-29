class Solution {
    public int sumOfBeauties(int[] nums) {
        int n=nums.length;
        int[] max=new int[n];
        int[] min=new int[n];
        for(int i=1;i<n;i++)
        {
            max[i]=Math.max(nums[i-1],max[i-1]);
        }
        min[n-2]=nums[n-1];
        for(int i=n-3;i>=0;i--)
        {
            min[i]=Math.min(nums[i+1],min[i+1]);
        }
        int sum=0;
        for(int i=1;i<n-1;i++)
        {
            if(nums[i]>max[i] && nums[i]<min[i])
            {
                sum=sum+2;
            }
            else if(nums[i]>nums[i-1] && nums[i]<nums[i+1])
            {
                sum++;
            }
        }
        return sum;
    }
}