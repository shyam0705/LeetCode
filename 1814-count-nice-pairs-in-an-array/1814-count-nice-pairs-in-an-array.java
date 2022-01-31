class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        long ans=0;
        int n=nums.length;
        long mod=1000000007;
        for(int i=0;i<n;i++)
        {
            int diff=nums[i]-rev(nums[i]);
            if(mp.containsKey(diff))
            {
                ans=(ans+(long)mp.get(diff))%mod;
               
            }
             mp.put(diff,mp.getOrDefault(diff,0)+1);
        }
        return (int)ans;
    }
    public int rev(int x){
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}