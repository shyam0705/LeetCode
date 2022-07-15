class Solution {
    boolean[][] visited;
    int[] arr1={1,0,-1,0};
    int[] arr2={0,1,0,-1};
    public int recur(int[][] mat,int n,int m,int i,int j)
    {
        int count=1;
        for(int k=0;k<4;k++)
        {
            int x=i+arr1[k];
            int y=j+arr2[k];
            if(x>=0 && y>=0 && x<n && y<m && !visited[x][y] && mat[x][y]==1)
            {
                visited[x][y]=true;
                count=count+recur(mat,n,m,x,y);
            }
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        visited=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!visited[i][j] && grid[i][j]==1)
                {
                    visited[i][j]=true;
                    int tmp=recur(grid,n,m,i,j);
                    ans=Math.max(tmp,ans);
                    
                }
            }
        }
        return ans;
    }
}