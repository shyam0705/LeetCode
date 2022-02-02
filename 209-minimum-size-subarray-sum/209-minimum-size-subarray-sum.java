class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int i=0;
        int j=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        while(i<n && j<n)
        {
            while(j<n && sum<target)
            {
                sum=sum+nums[j];
                j++;
            }
            while(i<n && sum>=target)
            {
                   // System.out.println(i+" "+j);
                ans=Math.min(ans,j-i);
                sum=sum-nums[i];
                // System.out.println(sum);
                i++;
            }
        }
        if(ans==Integer.MAX_VALUE)
            return 0;
        return ans;
    }
}