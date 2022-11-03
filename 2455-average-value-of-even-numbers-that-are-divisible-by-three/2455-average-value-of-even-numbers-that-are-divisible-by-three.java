class Solution {
    public int averageValue(int[] nums) {
        long sum=0;
        long count=0;
        int n=nums.length;
        
        for(int i=0;i<n;i++)
        {
            if(nums[i]%6==0)
            {
                sum=sum+(long)nums[i];
                count++;
            }
        }
        
        if(count==0)
            return 0;
        return (int)(sum/count);
    }
}