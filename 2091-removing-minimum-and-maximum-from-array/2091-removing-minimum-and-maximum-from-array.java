class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        if(n==1)
        {
            return 1;
        }
        int max_index=0;
        int min_index=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]<nums[min_index])
            {
                min_index=i;
            }
            if(nums[i]>nums[max_index])
            {
                max_index=i;
            }
        }
        if(min_index>max_index)
        {
            int tmp=min_index;
            min_index=max_index;
            max_index=tmp;
        }
        int ans=(min_index+1)+(n-max_index);
        ans=Math.min(ans,max_index+1);
        ans=Math.min(ans,n-min_index);
        return ans;
        
    }
}