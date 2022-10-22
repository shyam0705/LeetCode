class Solution {
    
    int n,m;
    boolean[][] visited;
    public boolean dfs(int i,int j,int[][] grid1,int[][] grid2)
    {
        boolean check=(grid1[i][j]==1);
        int[] arr1={1,-1,0,0};
        int[] arr2={0,0,1,-1};
        for(int k=0;k<4;k++)
        {
            int x=i+arr1[k];
            int y=j+arr2[k];
            if(x>=0 && y>=0 && x<n && y<m && grid2[x][y]==1 && !visited[x][y])
            {
                visited[x][y]=true;
                check=check & dfs(x,y,grid1,grid2);
            }
        }
        return check;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n=grid1.length;
        m=grid1[0].length;
        visited=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!visited[i][j] && grid2[i][j]==1)
                {
                    visited[i][j]=true;
                    boolean check=dfs(i,j,grid1,grid2);
                    if(check)
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}