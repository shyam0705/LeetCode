class Solution {
    int[][] dp;
    public int recur(int l,int r)
    {
        if(l>=r)
        {
            return 1;
        }
        if(dp[l][r]!=-1)
        {
            return dp[l][r];
        }
        int count=0;
        for(int i=l;i<=r;i++)
        {
            count=count+recur(l,i-1)*recur(i+1,r);
        }
        dp[l][r]=count;
        return count;
    }
    public int numTrees(int n) {
        dp=new int[n+1][n+1];
         for (int[] row : dp)
            Arrays.fill(row, -1);
        return recur(1,n);
    }
}