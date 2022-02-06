class Solution {
    public int removeDuplicates(int[] nums) {
        
        int n=nums.length;
        int last=nums[0];
        int count=1;
        int shift=0;
        for(int i=1;i<n;i++)
        {
            if(nums[i]==last)
            {
                if(count==2)
                {
                    shift++;
                }
                else
                {
                    nums[i-shift]=nums[i];
                    count++;
                }
            }
            else
            {
                count=1;
                last=nums[i];
                nums[i-shift]=nums[i];
            }
        }
        return n-shift;
    }
}