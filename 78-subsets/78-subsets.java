class Solution {
    List<List<Integer>>ans;
    // public void recur(int[] nums,int i,List<Integer>current,int n)
    // {
    //     if(i==n)
    //     {
    //         ans.add(new ArrayList<Integer>(current));
    //         return;
    //     }
    //     recur(nums,i+1,current,n);
    //     current.add(nums[i]);
    //     recur(nums,i+1,current,n);
    //     current.remove(current.size()-1);
    // }
    public List<List<Integer>> subsets(int[] nums) {
        ans=new ArrayList<>();
        int n=nums.length;
        int k=(1<<n)-1;
        while(k>=0)
        {
            List<Integer>current=new ArrayList<>();
            for(int i=0;i<32;i++)
            {
                int tmp=(k>>i)&1;
                if(tmp==1)
                {
                    current.add(nums[i]);
                }
            }
            ans.add(current);
            k--;
        }
        return ans;
    }
}