class Solution {
    public int maxSum(int[][] grid) {
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=1;i<n-1;i++)
        {
            for(int j=1;j<m-1;j++)
            {
               int[] arr1={-1,1};
               int[] arr2={0,1,-1};
                int sum=grid[i][j];
                for(int k=0;k<2;k++)
                {
                    for(int l=0;l<3;l++)
                    {
                        sum=sum+grid[i+arr1[k]][j+arr2[l]];
                    }
                }
                ans=Math.max(ans,sum);
            }
        }
        return ans;
    }
}