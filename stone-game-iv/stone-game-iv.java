class Solution {
    ArrayList<Integer>arr;
    int[] dp;
    public boolean recur(int n)
    {
        if(dp[n]!=-1)
        {
           return dp[n]==1;
        }
        for(Integer el:arr)
        {
            if(el<=n)
            {
                if(!recur(n-el))
                {
                    dp[n]=1;
                    return true;
                }
            }
            else
            {
                break;
            }
        }
        dp[n]=0;
        return false;
    }
    public boolean winnerSquareGame(int n) {
        arr=new ArrayList<>();
        dp=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            dp[i]=-1;
        }
        for(int i=1;i*i<=n;i++)
        {
            arr.add(i*i);
        }
        return recur(n);
    }
}