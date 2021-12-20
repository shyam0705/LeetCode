class Solution {
    public void reverse(int l,int r,int[] nums)
    {
        while(l<=r)
        {
            int tmp=nums[l];
            nums[l]=nums[r];
            nums[r]=tmp;
            l++;
            r--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int index=n-2;
        while(index>=0)
        {
            if(nums[index]>=nums[index+1])
            {
                index--;
            }
            else
            {
                break;
            }
        }
        if(index>=0)
        {
            for(int i=n-1;i>=index+1;i--)
            {
                if(nums[i]>nums[index])
                {
                    int tmp=nums[index];
                    nums[index]=nums[i];
                    nums[i]=tmp;
                    break;
                
                }
            }
        }
        reverse(index+1,n-1,nums);
        
    }
}