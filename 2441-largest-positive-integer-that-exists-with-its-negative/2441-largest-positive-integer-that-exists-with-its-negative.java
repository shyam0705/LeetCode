class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer>hs=new HashSet<>();
        int n=nums.length;
        
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(hs.contains(-nums[i]))
            {
                ans=Math.max(ans,Math.abs(nums[i]));
            }
            hs.add(nums[i]);
        }
        return ans==Integer.MIN_VALUE?-1:ans;
    }
}