class Solution {
    int t;
    double[][] dp;
    public double recur(int r,int c)
    {
        if(r==0 && c==0)
        {
            return t;
        }
        if(dp[r][c]!=-1)
        {
            return dp[r][c];
        }
        if(c==0)
        {
            double tmp=recur(r-1,c);
            if(tmp>1)
            {
                dp[r][c]=(tmp-1)/2;
                return (tmp-1)/2;
            }
            else
            {
                dp[r][c]=0;
                return 0;
            }
        }
        if(c==r)
        {
            double tmp=recur(r-1,c-1);
            if(tmp>1)
            {
                dp[r][c]=(tmp-1)/2;
                return (tmp-1)/2;
            }
            else
            {
                dp[r][c]=0;
                return 0;
            }
        }
        else
        {
            double tmp1=recur(r-1,c-1);
            double tmp2=recur(r-1,c);
            double tmp=0;
            if(tmp1>1)
            {
                tmp=tmp+(tmp1-1)/2;
            }
            if(tmp2>1)
            {
                tmp=tmp+(tmp2-1)/2;
            }
            dp[r][c]=tmp;
            return tmp;
        }
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        t=poured;
        dp=new double[query_row+1][query_glass+1];
        for(int i=0;i<=query_row;i++)
        {
            for(int j=0;j<=query_glass;j++)
            {
                dp[i][j]=-1;
            }
        }
        return Math.min(1,recur(query_row,query_glass));
    }
}