class Solution {
    public boolean isPossible(int[] nums) {
        int n=nums.length;
        if(n<3)
            return false;
        HashMap<Integer,PriorityQueue<Integer>>mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            //System.out.println(mp);
            if(mp.containsKey(nums[i]-1))
            {
                PriorityQueue<Integer> tmp_pq=mp.get(nums[i]-1);
                int tmp=tmp_pq.peek();
                if(tmp_pq.size()==1)
                {
                    mp.remove(nums[i]-1);
                }
                tmp_pq.remove();
                if(mp.containsKey(nums[i]))
                {
                    mp.get(nums[i]).add(tmp+1);
                }
                else
                {
                    PriorityQueue<Integer>pq=new PriorityQueue<>();
                    pq.add(tmp+1);
                    mp.put(nums[i],pq);
                }
            }
            else
            {
                if(mp.containsKey(nums[i]))
                {
                    mp.get(nums[i]).add(1);
                }
                else
                {
                    PriorityQueue<Integer>pq=new PriorityQueue<>();
                    pq.add(1);
                    mp.put(nums[i],pq);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
           
            if(mp.containsKey(nums[i]))
            {
                //System.out.println(nums[i]+" "+mp.get(nums[i]));
                int tmp=mp.get(nums[i]).peek();
                if(tmp>0 && tmp<3)
                    return false;
            }
            
        }
        return true;
    }
}