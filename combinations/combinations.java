class Solution {
    List<List<Integer>>ans;
    public void recur(int n,int k,List<Integer>current,int i)
    {
        if(i>n)
        {
             if(k==0)
            {
                ans.add(new ArrayList<>(current));
            }
            return;
        }
        if(k==0)
        {
            ans.add(new ArrayList<>(current));
        }
        for(int j=i;j<=n;j++)
        {
            current.add(j);
            recur(n,k-1,current,j+1);
            current.remove(current.size()-1);
        }
        
    }
    public List<List<Integer>> combine(int n, int k) {
        ans=new ArrayList<>();
        recur(n,k,new ArrayList<>(),1);
        return ans;
    }
}