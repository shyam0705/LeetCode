class Solution {
    int n;
    int m;
    int[][][][] dp;
    public int recur(int[][] grid,int a,int b,int c,int d)
    {
        int[] tmp1={-1,0,1};
        // System.out.println(n+" "+m);
        // System.out.println(a+" "+b+" "+c+" "+d);
        if(a==n-1 &&  c==n-1)
        {
            // System.out.println(grid[a][b]);
            if(b==d)
            {
                return grid[a][b];
            }
            else
            {
                return grid[a][b]+grid[c][d];
            }
            
        }
        if(dp[a][b][c][d]!=-1)
        {
            return dp[a][b][c][d];
        }
        int tmp_value1=grid[a][b];
        grid[a][b]=0;
        int tmp_value2=grid[c][d];
        grid[c][d]=0;
        int ans=0;
        if(a==n-1)
        {
            // System.out.println("hello");
            for(int j=0;j<3;j++)
            {
                int x=c+1;
                int y=d+tmp1[j];
                if(x>=0 && y>=0 && x<n && y<m)
                {
                    
                    ans=Math.max(ans,tmp_value1+tmp_value2+recur(grid,a,b,x,y));
                }
            }
        }
        else if(c==n-1)
        {
             // System.out.println("hello");
            for(int j=0;j<3;j++)
            {
                int x=a+1;
                int y=b+tmp1[j];
                if(x>=0 && y>=0 && x<n && y<m)
                {
                   
                    ans=Math.max(ans,tmp_value1+tmp_value2+recur(grid,x,y,c,d));
                }
            }
        }
        else
        {
            for(int j=0;j<3;j++)
            {
                for(int k=0;k<3;k++)
                {
                     int x1=a+1;
                     int y1=b+tmp1[j];
                     int x2=c+1;
                     int y2=d+tmp1[k]; 
                     if(x1>=0 && y1>=0 && x2>=0 && y2>=0 && x1<n && y1<m && x2<n && y2<m)
                     {
                         // System.out.println(x1+" "+y1+" "+x2+" "+y2);
                         ans=Math.max(ans,tmp_value1+tmp_value2+recur(grid,x1,y1,x2,y2));
                     }
                     
                }
            }
        }
        if(a!=c || b!=d)
        {
            grid[a][b]=tmp_value1;
            grid[c][d]=tmp_value2;
        }
        else
        {
            grid[a][b]=tmp_value1;
        }
        dp[a][b][c][d]=ans;
        return ans;
             
    }
    public int cherryPickup(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        dp=new int[n][m][n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                for(int k=0;k<n;k++)
                {
                    for(int l=0;l<m;l++)
                    {
                        dp[i][j][k][l]=-1;
                    }
                }
            }
        }
        return recur(grid,0,0,0,m-1);
    }
}