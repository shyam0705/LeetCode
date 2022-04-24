class Solution {
    public List<Integer> intersection(int[][] nums) {
        TreeSet<Integer>set=new TreeSet();
        for(int i=0;i<nums[0].length;i++)
        {
            set.add(nums[0][i]);
        }
        int n=nums.length;
        
        for(int i=1;i<n;i++)
        {
           HashSet<Integer>hs=new HashSet();
         for(int j=0;j<nums[i].length;j++)
         {
            hs.add(nums[i][j]);
         }
         set.removeIf((Integer element) -> {
                    return (!hs.contains(element));
        });
        }
        List<Integer>ans=new ArrayList();
        for(Integer el:set)
        {
            ans.add(el);
        }
        return ans;
        
    }
}