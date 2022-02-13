class Solution {
    List<List<Integer>>ans;
    public void recur(int[] nums,int i,List<Integer>current,int n)
    {
        if(i==n)
        {
            ans.add(new ArrayList<Integer>(current));
            return;
        }
        recur(nums,i+1,current,n);
        current.add(nums[i]);
        recur(nums,i+1,current,n);
        current.remove(current.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        ans=new ArrayList<>();
        int n=nums.length;
        recur(nums,0,new ArrayList<>(),n);
        return ans;
    }
}