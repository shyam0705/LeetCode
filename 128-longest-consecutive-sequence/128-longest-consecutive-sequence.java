class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0)
        {
            return 0;
        }
        Arrays.sort(nums);
        int i=0;
        int j=1;
        int ans=Integer.MIN_VALUE;
        while(i<n)
        {
            int count=1;
            while(j<n && (nums[j]==nums[j-1] || nums[j]==(nums[j-1]+1)))
            {
                if(nums[j]==(nums[j-1]+1))
                {
                    count++;
                }
                
                j++;
            }
            ans=Math.max(ans,count);
            i=j;
            j++;
        }
        return ans;
        
    }
}