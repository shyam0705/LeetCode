class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            nums[i]=nums[i]==0?-1:nums[i];
        }
        HashMap<Integer,Integer>mp=new HashMap<>();
        int sum=0;
        mp.put(0,-1);
        int ans=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+nums[i];
            if(mp.containsKey(sum))
            {
                ans=Math.max(ans,i-mp.get(sum));
            }
            else
            {
                mp.put(sum,i);
            }
        }
        return ans;
    }
}