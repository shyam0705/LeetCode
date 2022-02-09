class Solution {
    public int findPairs(int[] nums, int k) {
        HashSet<Integer>hs=new HashSet<>();
        HashSet<String>hs2=new HashSet<>();
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            int tmp1=nums[i]+k;
            int tmp2=nums[i]-k;
            if(hs.contains(tmp1))
            {
                String tmp=tmp1+"$"+nums[i];
                if(!hs2.contains(tmp))
                {
                    count++;
                    hs2.add(tmp);
                }
            }
            if(hs.contains(tmp2))
            {
                String tmp=nums[i]+"$"+tmp2;
                if(!hs2.contains(tmp))
                {
                    count++;
                    hs2.add(tmp);
                }
            }
            hs.add(nums[i]);
        }
        return count;
    }
}