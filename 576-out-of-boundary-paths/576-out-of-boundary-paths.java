class Solution {
    long mod;
    long[][][] dp;
    public long recur(int n,int m,int i,int j,int target)
    {
        if(target==0)
        {
            return 0; 
        }
        if(dp[i][j][target]!=-1)
        {
            return dp[i][j][target];
        }
        int[] arr1={1,0,-1,0};
        int[] arr2={0,-1,0,1};
        long count=0;
        for(int k=0;k<4;k++)
        {
            int x=i+arr1[k];
            int y=j+arr2[k];
            if(x>=0 && y>=0 && x<n && y<m)
            {
                count=(count+recur(n,m,x,y,target-1))%mod;
            }
            else
            {
                count=(count+1)%mod;
            }
        }
        dp[i][j][target]=count;
        return count;
        
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp=new long[m][n][maxMove+1];
        mod=1000000007;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<=maxMove;k++)
                {
                    dp[i][j][k]=-1;
                }
                
            }
        }
        return (int)recur(m,n,startRow,startColumn,maxMove);
    }
}