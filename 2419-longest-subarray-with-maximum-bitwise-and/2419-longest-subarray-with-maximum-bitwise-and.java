class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int last_f=1;
        int last=nums[0];
        int max_el=nums[0];
        int max=1;
        for(int i=1;i<n;i++)
        {
            if((last&nums[i])==nums[i])
            {
                last_f=last_f+1;
            }
            else
            {
                last_f=1;
            }
            if(nums[i]==max_el)
            {
                max=Math.max(max,last_f);
            }
            else if(nums[i]>max_el)
            {
                max_el=nums[i];
                max=last_f;
            }
            last=nums[i];
        }
        
        return max;
    }
}