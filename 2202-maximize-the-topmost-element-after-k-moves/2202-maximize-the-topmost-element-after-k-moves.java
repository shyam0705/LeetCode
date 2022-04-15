class Solution {
    public int maximumTop(int[] nums, int k) {
        int max=-1;
        int n=nums.length;
        if(n==1)
        {
            if(k%2==0)
            {
                return nums[0];
            }
            return -1;
        }
        if(k>n)
        {
            for(int i=0;i<n;i++)
            {
                max=Math.max(max,nums[i]);
            }
            return max;
        }
        for(int i=0;i<=Math.min(k,n-1);i++)
        {
            if(i+1!=k)
            {
                max=Math.max(nums[i],max);
            }
        }
        return max;
    }
}