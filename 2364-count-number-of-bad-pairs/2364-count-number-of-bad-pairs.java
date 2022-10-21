class Solution {
    public long countBadPairs(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            nums[i]-=i;
        }
        long count=0;
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(mp.containsKey(nums[i]))
            {
                count=count+(long)mp.get(nums[i]);
            }
           
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            
        }
        // System.out.println(count);
        long total=((long)n*(long)(n-1))/2;
        return total-count;
    }
}