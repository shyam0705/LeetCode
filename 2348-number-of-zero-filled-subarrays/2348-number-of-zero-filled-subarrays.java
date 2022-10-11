class Solution {
    public long zeroFilledSubarray(int[] nums) {

        long count=0;
        int i=0;
        int n=nums.length;
        while(i<n)
        {
            
            if(nums[i]==0)
            {
                long tmp=0;
                while(i<n && nums[i]==0)
                {
                    tmp++;
                    i++;
                }
                count=count+(tmp)*(tmp+1)/2;
            }
            else
            {
                i++;
            }
        }
        return count;
    }
}