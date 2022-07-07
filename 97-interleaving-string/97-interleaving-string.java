class Solution {
    int n,m,l;
    int[][] dp;
    public boolean recur(String s1,String s2,String s3,int i,int j,int k)
    {
        if(k==l)
        {
            if(j!=m || i!=n)
                return false;
            return true;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j]==1;
        }
        if(i<n && s1.charAt(i)==s3.charAt(k))
        {
            boolean check=recur(s1,s2,s3,i+1,j,k+1);
            if(check)
            {
                dp[i][j]=1;
                return true;
            }
        }
        if(j<m && s2.charAt(j)==s3.charAt(k))
        {
            boolean check=recur(s1,s2,s3,i,j+1,k+1);
            if(check)
            {
                dp[i][j]=1;
                return true;
            }
        }
        dp[i][j]=0;
        return false;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        n=s1.length();
        m=s2.length();
        l=s3.length();
        if(n==0 && m==0 && l==0)
            return true;
        dp=new int[201][201];
        for(int i=0;i<=200;i++)
        {
            for(int j=0;j<=200;j++)
            {
                dp[i][j]=-1;
            }
        }
        return recur(s1,s2,s3,0,0,0);
        
    }
}