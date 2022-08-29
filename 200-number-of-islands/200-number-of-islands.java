class Solution {
    int n,m;
    public void dfs(char[][] grid,boolean[][] visited,int i,int j)
    {
        int[] arr1={1,-1,0,0};
        int[] arr2={0,0,1,-1};
        for(int k=0;k<4;k++)
        {
            int x=arr1[k]+i;
            int y=arr2[k]+j;
            if(x>=0 && y>=0 && x<n && y<m && !visited[x][y] && grid[x][y]=='1')
            {
                visited[x][y]=true;
                dfs(grid,visited,x,y);
            }
        }
    }
    public int numIslands(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!visited[i][j] && grid[i][j]=='1')
                {
                    visited[i][j]=true;
                    count++;
                    dfs(grid,visited,i,j);
                }
            }
        }
        return count;
    }
}