class Solution {
     public  void recur(int open,int close,List<String>ans,String current,int n)
    {
        if(open>n || close>n)
        {
            return;
        }
        if(open==n && close==n)
        {
            ans.add(current);
            return;
        }
        if(open>close)
        {
            recur(open+1,close,ans,current+"(",n);
            recur(open,close+1,ans,current+")",n);
        }
        else
        {
            recur(open+1,close,ans,current+"(",n);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        recur(0,0,ans,"",n);
        return ans;
    }
}