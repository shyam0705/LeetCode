class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int n=nums.length;
        int count=0;
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(mp.containsKey(nums[i]-diff) && mp.containsKey(nums[i]-2*diff))
            {
               count=count+Math.min(mp.get(nums[i]-diff),mp.get(nums[i]-2*diff));
            }
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        return count;
    }
}