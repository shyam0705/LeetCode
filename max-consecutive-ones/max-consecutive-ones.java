class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int last_one=-1;
        int ans=0;
        int i=0;
        for(i=0;i<n;i++)
        {
            if(nums[i]==0)
            {
                if(last_one!=-1)
                {
                    ans=Math.max(ans,i-last_one);
                    last_one=i-1;
                    last_one=-1;
                }
            }
            if(nums[i]==1 && last_one==-1)
            {
                last_one=i;
            }
        }
        if(last_one!=-1)
        {
            ans=Math.max(ans,i-last_one);
        }
        return ans;
    }
}