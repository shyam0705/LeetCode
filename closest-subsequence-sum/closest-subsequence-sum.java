class Solution {
    int ans;
    int n;
    TreeSet<Integer>hs;
    Set<Integer>l;
    public void recur(int[] nums,int i,int sum,int m)
    {
       
        if(i>m)
        {
            hs.add(sum);
           return; 
        }
        recur(nums,i+1,sum+nums[i],m);
        recur(nums,i+1,sum,m);
    }
    public void recur1(int[] nums,int i,int sum)
    {
       
        if(i>=n)
        {
            l.add(sum);
           return; 
        }
        recur1(nums,i+1,sum+nums[i]);
        recur1(nums,i+1,sum);
    }
    public int minAbsDifference(int[] nums, int goal) {
        n=nums.length;
        int m=n/2-1;
        hs=new TreeSet<>();
        l=new HashSet<>();
        recur(nums,0,0,m);
        recur1(nums,m+1,0);
        int ans=Integer.MAX_VALUE;
        for(Integer el:l)
        {
                    
                if(hs.contains(goal-el))
                {
                    return 0;
                }
                Integer tmp=hs.floor(goal-el);
                if(tmp!=null)
                {
                    ans=Math.min(ans,Math.abs(tmp+el-goal));
                }
                tmp=hs.ceiling(goal-el);
                if(tmp!=null)
                {
                    ans=Math.min(ans,Math.abs(tmp+el-goal));
                }
        }
        return ans;
    }
}