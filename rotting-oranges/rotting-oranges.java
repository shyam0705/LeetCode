class Solution {
    class Pair{
        int x,y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j));
                }
            }
        }
        int count=0;
        int[] tmp1={1,-1,0,0};
        int[] tmp2={0,0,1,-1};
        while(!q.isEmpty())
        {
            int l=q.size();
            boolean modify=false;
            for(int i=0;i<l;i++)
            {
                Pair tmp=q.remove();
                for(int k=0;k<4;k++)
                {
                    int x=tmp.x+tmp1[k];
                    int y=tmp.y+tmp2[k];
                    if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==1)
                    {
                        grid[x][y]=2;
                        modify=true;
                        q.add(new Pair(x,y));
                    }
                        
                }
            }
            if(!modify)
            {
                break;
            }
            count++;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    return -1;
                }
            }
        }
        return count;
    }
}