class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        if(n==1)
        {
            return 0;
        }
        int max_end=nums[0];
        int count=0;
        int max=Integer.MIN_VALUE;
        for(int i=1;i<n;i++)
        {
            if(i>max_end)
            {
                count=count+1;
                max_end=max;
                max=i+nums[i];
            }
            else
            {
               max=Math.max(max,i+nums[i]);
            }
        }
        return count+1;
        
    }
}