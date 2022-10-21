class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n=nums.length;
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);
        for(int i=1;i<n;i++)
        {
            if(nums[i]<=nums[i-1])
            {
                dp1[i]=dp1[i-1]+1;
            }
        }
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<=nums[i+1])
            {
                dp2[i]=dp2[i+1]+1;
            }
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=1;i<n-1;i++)
        {
            if(dp1[i-1]>=k && dp2[i+1]>=k)
            {
                ans.add(i);
            }
        }
        return ans;
    }
}