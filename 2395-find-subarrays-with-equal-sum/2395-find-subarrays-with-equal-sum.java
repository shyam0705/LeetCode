class Solution {
    public boolean findSubarrays(int[] nums) {
        HashSet<Integer>hs=new HashSet<>();
        int n=nums.length;
        if(n<=2)
            return false;
        for(int i=0;i<n-1;i++)
        {
            int sum=nums[i]+nums[i+1];
            if(hs.contains(sum))
                return true;
            hs.add(sum);
        }
        return false;
    }
}