class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer>mp=new HashMap<>();
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            if(i>=1 && sum%k==0)
                return true;
            if(mp.containsKey(sum%k))
            {
                if((i-mp.get(sum%k))>=2)
                    return true;
            }
            else
            {
                 mp.put(sum%k,i);
            }
           
        }
        return false;
    }
}