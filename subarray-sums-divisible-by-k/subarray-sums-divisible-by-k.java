class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        mp.put(0,1);
        int sum=0;
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            sum=sum+nums[i];
            int r=sum%k;
            if(r<0)
            {
                r=r+k;
            }
            if(mp.containsKey(r))
            {
                count=count+mp.get(r);
            }
            mp.put(r,mp.getOrDefault(r,0)+1);
        }

        return count;
    }
}