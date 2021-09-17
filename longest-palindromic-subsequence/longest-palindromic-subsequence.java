class Solution {
    int[][] dp;
    public int recur(String s,int i,int j)
    {
        if(i>j)
        {
            return 0;
        }
        if(i==j)
        {
            return 1;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j))
        {
            int ans=2+recur(s,i+1,j-1);
            dp[i][j]=ans;
            return ans;
        }
        else
        {
            int ans=Math.max(recur(s,i+1,j),recur(s,i,j-1));
            dp[i][j]=ans;
            return ans;
        }
    }
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        dp=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
        return recur(s,0,n-1);
    }
}