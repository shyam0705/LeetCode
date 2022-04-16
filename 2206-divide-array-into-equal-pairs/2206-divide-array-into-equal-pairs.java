class Solution {
    public boolean divideArray(int[] nums) {
        int n=nums.length;
       HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        
       for(int k:mp.keySet())
       {
           if(mp.get(k)%2!=0)
           {
                return false;
           }
       }
        return true;
    }
}