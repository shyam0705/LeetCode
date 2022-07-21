class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                dp[i][j]=matrix[i-1][j-1]+dp[i][j-1];
            }
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                dp[i][j]=dp[i][j]+dp[i-1][j];
            }
        }
      
        int count=0;
        for(int x=1;x<=n;x++)
        {
            for(int y=1;y<=m;y++)
            {
                for(int i=1;i<=x;i++)
                {
                    for(int j=1;j<=y;j++)
                    {
                        int sum=dp[x][y]-dp[x-i][y]-dp[x][y-j]+dp[x-i][y-j];
                        // System.out.print(sum+" ");
                        if(sum==target)
                            count++;
                    }
                }
                // System.out.println();
            }
        }
        return count;
    }
}