class Solution {
    boolean[][] visited;
    int n,m;
    public int recur(int[][] grid,int x,int y,int final_x,int final_y)
    {
        if(x==final_x && y==final_y)
        {
            // System.out.println("Hello");
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(grid[i][j]==0 && !visited[i][j])
                    {
                        return 0;
                    }
                }
            }
            return 1;
        }
        int count=0;
        int[] arr1={1,-1,0,0};
        int[] arr2={0,0,-1,1};
        visited[x][y]=true;
        for(int k=0;k<4;k++)
        {
            int i=x+arr1[k];
            int j=y+arr2[k];
            //System.out.println(i+" "+j);
            if(i>=0 && j>=0 && i<n && j<m && !visited[i][j] && grid[i][j]!=-1)
            {
                // System.out.println(i+" "+j);
                int tmp=recur(grid,i,j,final_x,final_y);
                count=count+tmp;
            }
        }
        visited[x][y]=false;
        return count;
    }
    public int uniquePathsIII(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        // System.out.println(n+" "+m);
        visited=new boolean[n][m];
        int start_x=-1;
        int start_y=-1;
        int final_x=-1;
        int final_y=-1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    start_x=i;
                    start_y=j;
                }
                if(grid[i][j]==2)
                {
                    final_x=i;
                    final_y=j;
                }
            }
        }
        // System.out.println(start_x+" "+start_y+" "+final_x+" "+final_y);
        int ans=recur(grid,start_x,start_y,final_x,final_y);
        return ans;
    }
}