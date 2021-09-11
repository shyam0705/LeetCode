class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        ArrayList<HashMap<Long,Integer>>mp=new ArrayList<>();
        int count=0;
        mp.add(new HashMap<>());
        for(int i=1;i<n;i++)
        {
            HashMap<Long,Integer>curr=new HashMap<>();
            for(int j=0;j<i;j++)
            {
                long diff=(long)nums[i]-(long)nums[j];
                HashMap<Long,Integer>prev=mp.get(j);
                int num=prev.getOrDefault(diff,0);
                count=count+num;
                curr.put(diff,curr.getOrDefault(diff,0)+num+1);
            }
            mp.add(curr);
        }
        return count;
        
        
    }
}