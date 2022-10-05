class Solution {
    public int mostFrequentEven(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer>mp=new HashMap<>();
        int ans=-1;
        int ans_freq=0;
        for(int i=0;i<n;i++)
        {
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            int f=mp.get(nums[i]);
            if(nums[i]%2==0)
            {
                if(f>ans_freq)
                {
                    ans=nums[i];
                    ans_freq=f;
                }
                else if(f==ans_freq && nums[i]<ans)
                {
                    ans=nums[i];
                }
            }
        }
        return ans;
    }
}