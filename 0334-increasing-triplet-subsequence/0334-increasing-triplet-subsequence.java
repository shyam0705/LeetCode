class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        left[0]=-1;
        int left_min=0;
        for(int i=1;i<n;i++)
        {
            if(nums[i]<=nums[left_min])
            {
                left[i]=-1;
                left_min=i;
            }
            else
            {
                left[i]=left_min;
            }
        }
        int[] right=new int[n];
        right[n-1]=-1;
        int right_max=n-1;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]>=nums[right_max])
            {
                right[i]=-1;
                right_max=i;
            }
            else
            {
                right[i]=right_max;
            }
        }
        
        for(int i=1;i<n;i++)
        {
            if(left[i]!=-1 && right[i]!=-1 && nums[right[i]]>nums[left[i]])
            {
                return true;
            }
        }
        return false;
    }
}