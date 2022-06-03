class NumMatrix {

    int[][] dp;
    int n;
    int m;
    public NumMatrix(int[][] matrix) {
        n=matrix.length;
        m=matrix[0].length;
        dp=new int[n+1][m+1];
        for(int i=0;i<m;i++)
        {
            dp[0][i]=0;
        }
        for(int j=0;j<n;j++)
        {
            dp[j][0]=0;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                dp[i][j]=dp[i][j-1]+matrix[i-1][j-1];
            }
        }
        for(int j=1;j<=m;j++)
        {
            for(int i=1;i<= n;i++)
            {
                dp[i][j]+=dp[i-1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1]-dp[row1][col2+1]-dp[row2+1][col1]+dp[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */