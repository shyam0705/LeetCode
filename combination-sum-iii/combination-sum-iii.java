class Solution {
    List<List<Integer>> ans;
    public void recur(int k,int sum,List<Integer>current,int last)
    {
        if(k==0)
        {
            if(sum==0)
            {
                ans.add(new ArrayList<>(current));
                return;
            }
            else
            {
                return;
            }
        }
        for(int i=last+1;i<=9;i++)
        {
            if(i>sum)
            {
                return;
            }
            else
            {
                current.add(i);
                recur(k-1,sum-i,current,i);
                current.remove(current.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans=new ArrayList<>();
        recur(k,n,new ArrayList<>(),0);
        return ans;
    }
}