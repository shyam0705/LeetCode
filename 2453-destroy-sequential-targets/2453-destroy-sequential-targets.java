class Solution {
    public int destroyTargets(int[] nums, int space) {
        int n=nums.length;
        Arrays.sort(nums);
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int tmp=nums[i]%space;
            mp.put(tmp,mp.getOrDefault(tmp,0)+1);
            
        }
        
        int ans=nums[0];
        int max=mp.get(ans%space);
        for(int i=1;i<n;i++)
        {
            int tmp=mp.get(nums[i]%space);
            if(tmp>max)
            {
                max=tmp;
                ans=nums[i];
            }
        }
        return ans;
    }
}