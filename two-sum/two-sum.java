class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        int[] ans=new int[2];
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            int k=target-nums[i];
            if(mp.containsKey(k))
            {
                ans[0]=mp.get(k);
                ans[1]=i;
                break;
            }
            mp.put(nums[i],i);
        }
        return ans;
    }
}