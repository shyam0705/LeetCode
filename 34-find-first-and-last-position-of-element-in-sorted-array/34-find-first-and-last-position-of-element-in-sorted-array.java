class Solution {
    public int findStart(int[] nums,int target)
    {
        int n=nums.length;
        int l=0;
        int r=n-1;
        int index=-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(nums[mid]==target)
            {
                index=mid;
            }
            if(nums[mid]>=target)
            {
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return index;
    }
    public int findEnd(int[] nums,int target)
    {
        int n=nums.length;
        int l=0;
        int r=n-1;
        int index=-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(nums[mid]==target)
            {
                index=mid;
            }
            if(nums[mid]>target)
            {
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return index;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        ans[0]=findStart(nums,target);
        ans[1]=findEnd(nums,target);
        return ans;
    }
}