class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        int n=nums.length;
        
        for(int i=0;i<n;i++)
        {
            mp.put(nums[i],i);
        }
        
        int m=operations.length;
        
        for(int i=0;i<m;i++)
        {
            int u=operations[i][0];
            int v=operations[i][1];
            int index=mp.get(u);
            
            mp.remove(u);
            mp.put(v,index);
        }
        
        mp.forEach((k,v)->{
            nums[v]=k;
        });
        
        return nums;
    }
}