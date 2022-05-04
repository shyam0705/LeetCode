class Solution {
    public int maxOperations(int[] nums, int k) {
       HashMap<Integer,Integer>mp=new HashMap<>();
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(mp.containsKey(k-nums[i]))
            {
                count++;
                int tmp=mp.get(k-nums[i]);
                if(tmp==1)
                {
                    mp.remove(k-nums[i]);
                }
                else
                {
                    mp.put(k-nums[i],tmp-1);
                }
            }
            else
            {
                mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            }
        }
        return count;
        
    }
}