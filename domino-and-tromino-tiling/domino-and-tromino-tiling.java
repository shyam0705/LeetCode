class Solution {
    long[] dp1;
    long[] dp2;
    long m=1000000007;
    public long normal(int i,int n)
    {
        if(i>=n)
        {
            return 0;
        }
        if(i==n-1)
        {
            return 1;
        }
        if(i==n-2)
        {
            return 2;
        }
        if(dp1[i]!=-1)
        {
            return dp1[i];
        }
        long ans=(normal(i+1,n)+normal(i+2,n)+2*recur(i+1,n))%m;
        dp1[i]=ans;
        return ans;
    
    }
    public long recur(int i,int n)
    {
        if(i>=n-1)
        {
            return 0;
        }
        if(i==n-2)
        {
            return 1;
        }
        if(dp2[i]!=-1)
        {
            return dp2[i];
        }
        long ans=(normal(i+2,n)+recur(i+1,n))%m;
        dp2[i]=ans;
        return ans;
    }
    public int numTilings(int n) {
        dp1=new long[n];
        dp2=new long[n];
        for(int i=0;i<n;i++)
        {
            dp1[i]=-1;
            dp2[i]=-1;
        }
        return (int)normal(0,n);
    }
}