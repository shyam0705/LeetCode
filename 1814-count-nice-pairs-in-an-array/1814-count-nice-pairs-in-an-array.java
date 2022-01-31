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
    public int rev(int n){
        String s=Integer.toString(n);
        String rev="";
        int r=s.length()-1;
        while(r>=0)
        {
            rev=rev+s.charAt(r);
            r--;
        }
        return Integer.parseInt(rev);
    }
}