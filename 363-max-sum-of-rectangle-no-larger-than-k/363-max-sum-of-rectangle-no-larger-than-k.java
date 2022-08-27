class Solution {
    public int maxSumSubmatrix(int[][] matrix, int target) {
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
        // for(int i=0;i<=n;i++)
        // {
        //     for(int j=0;j<=m;j++)
        //     {
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                for(int l=j;l<=m;l++)
                {
                     for(int k=i;k<=n;k++)
                    {
                        int total=dp[k][l]-dp[i-1][l]-dp[k][j-1]+dp[i-1][j-1];
                        if(total<=target)
                        {
                            ans=Math.max(ans,total);
                        }
                    
                    }
                }
               
            }
        }
        return ans;
    }
}