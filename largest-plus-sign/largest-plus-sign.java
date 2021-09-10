class Solution {
    public int orderOfLargestPlusSign(int n, int[][] arr) {
        int[][] mines=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                mines[i][j]=1;
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            mines[arr[i][0]][arr[i][1]]=0;
        }
        int[][][] dp=new int[n][n][4];
        dp[0][0][0]=mines[0][0]==1?1:0;
        dp[0][0][1]=mines[0][0]==1?1:0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mines[i][j]==0)
                {
                    dp[i][j][0]=0;
                    dp[i][j][1]=0;
                    continue;
                }
                if(i==0 && j==0)
                {
                    continue;
                }
                else if(i==0)
                {
                    dp[i][j][1]=mines[i][j]==1?1:0;
                    dp[i][j][0]=1+dp[i][j-1][0];
                }
                else if(j==0)
                {
                    dp[i][j][0]=mines[i][j]==1?1:0;
                    dp[i][j][1]=dp[i-1][j][1]+1;
                }
                else
                {
                   dp[i][j][0]=1+dp[i][j-1][0];
                    dp[i][j][1]=1+dp[i-1][j][1];
                }
                
            }
        }
        dp[n-1][n-1][2]=mines[n-1][n-1]==1?1:0;
        dp[n-1][n-1][3]=mines[n-1][n-1]==1?1:0;
        for(int i=n-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(mines[i][j]==0)
                {
                    dp[i][j][2]=0;
                    dp[i][j][3]=0;
                    continue;
                }
                if(i==n-1 && j==n-1)
                {
                    continue;
                }
                else if(i==n-1)
                {
                    dp[i][j][3]=mines[i][j]==1?1:0;
                    dp[i][j][2]=dp[i][j+1][2]+1;
                }
                else if(j==n-1)
                {
                    dp[i][j][2]=mines[i][j]==1?1:0;
                    dp[i][j][3]=dp[i+1][j][3]+1;
                }
                else
                {
                    dp[i][j][2]=1+dp[i][j+1][2];
                    dp[i][j][3]=1+dp[i+1][j][3];
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int min=Math.min(dp[i][j][0],dp[i][j][1]);
                min=Math.min(min,dp[i][j][2]);
                min=Math.min(min,dp[i][j][3]);
                ans=Math.max(ans,min);
            }
        }
        return ans;
        
    }
}